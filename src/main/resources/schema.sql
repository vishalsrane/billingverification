

drop table billing_group;
drop table billing_rule;

CREATE TABLE IF NOT EXISTS billing_group (
    id        bigserial  PRIMARY KEY,
    name       varchar(40) NOT NULL,
    description         varchar(40) NOT NULL,
    query   varchar(40) NOT NULL
);



CREATE TABLE IF NOT EXISTS billing_rule (
    id        bigserial  PRIMARY KEY,
    name       varchar(40) NOT NULL,
    billing_group_id bigint
);
	
