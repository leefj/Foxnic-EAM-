delete from eam_warehouse_position where code='def';
insert into eam_warehouse_position(id,warehouse_id,code,name) select id,id,'def','默认库位' from eam_warehouse;
update eam_warehouse_position set id=warehouse_id where code='def';
update eam_goods_stock set position_id=warehouse_id where (position_id is null or position_id='') and warehouse_id in (select warehouse_id from eam_warehouse_position where code='def');
