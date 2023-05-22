<template>
  <div id="app">
    <VFormDesigner ref="vfDesignerRef" :designer-config="designerConfig" :global-dsv="globalDsv">
      <template #customToolButtons>
        <el-button type="text" @click="saveJson">保存</el-button>
      </template>
    </VFormDesigner>
  </div>
</template>

<script>
import VFormDesigner from './components/form-designer/index.vue'
import {
  addWindowResizeHandler,
  deepClone,
  getAllContainerWidgets,
  getAllFieldWidgets,
  getQueryParam, traverseAllWidgets
} from "@/utils/util"
import {MOCK_CASE_URL, VARIANT_FORM_VERSION} from "@/utils/config"
import axios from "axios"

export default {
  name: 'App',
  components: {
    VFormDesigner,
  },
  data() {
    return {
      jsonDefData:{},
      formId:"",
      designerConfig: {
        externalLink: false,
        resetFormJson: false,
        toolbarMaxWidth: 490,
      },
      //全局数据源变量
      globalDsv: {
        testApiHost: 'http://www.test.com/api',
        testPort: 8080,
      },
    }
  },
  created() {
    this.formId = getQueryParam('formId');
    console.log("formId:"+this.formId);

    // this.importTemplate = JSON.stringify(this.designer.getImportTemplate(), null, '  ')
    // this.showImportJsonDialogFlag = true

  },
  mounted(){

      console.log("formId:"+this.formId)
      var _this=this;
      axios.post('/service-common/sys-form-def/get-by-id',{"id":this.formId}).
      then( function(res) {
        var resData=res.data;
        if(resData.success){
            try {
              var jsonStr=resData.data.designerData;
              var jsonStr2= JSON.stringify(jsonStr, null, '  ')
              //不知道为啥，要parse两次，第一次转没效果
              var jsonStrTmp = JSON.parse(jsonStr2)
              var importObj = JSON.parse(jsonStrTmp)
              _this.jsonDefData=importObj;
              _this.$refs.vfDesignerRef.designer.loadFormJson(importObj)
              _this.$refs.vfDesignerRef.designer.emitHistoryChange()
              _this.$refs.vfDesignerRef.designer.emitEvent('form-json-imported', [])
            } catch(ex) {
              console.log('err')
              console.log(ex)
              _this.$message.error(ex + '')
            }
        }else{
          this.$message.error(resData.message)
        }
      }).catch(err=>{
        console.log(err);
      })

  },
  methods: {
    saveJson() {
      var jsonData=this.$refs.vfDesignerRef.getFormJson();
      var jsonDataStr=JSON.stringify(jsonData);
      var _this=this;
      axios.post('/service-common/sys-form-def/save-form-by-id',{"id":this.formId,"designerData":jsonDataStr}).
      then( function(res) {
              var resData=res.data;
              if(resData.success){
                _this.$message.success(resData.message);
              }else{
                _this.$message.error(resData.message)
              }
      }).catch(err=>{
        console.log(err);
      })
    }
  }
}
</script>

<style lang="scss">
  #app {
    height: 100%;
  }
</style>
