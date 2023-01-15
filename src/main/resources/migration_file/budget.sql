create table budget(
id int auto_increment,
budgetid varchar(256), -- maintain proper convention
sap_code varchar(256), -- sap_code is not understandable, give a proper name
product_name varchar(256),
production_unit varchar(256),
package_size varchar(256),
SBU varchar(256), -- maintain proper convention
field_colleagueid varchar(256), -- maintain proper convention
field_colleague_name varchar(256), -- discuss with me
quantity int, -- can we use bigint
depot_name varchar(256),
depotid varchar(256),  -- maintain proper convention
category varchar(256),
month varchar(256),
year int,
ssu_id varchar(256),
is_depot_received boolean, -- discuss with me
is_inssu boolean, -- not understandable
CONSTRAINT budget_pk PRIMARY KEY (id) -- CONSTRAINT budget_pk  it means
);