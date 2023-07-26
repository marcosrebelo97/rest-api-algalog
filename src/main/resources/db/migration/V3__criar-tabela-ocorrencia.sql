CREATE TABLE ocorrencia (
	id          SERIAL NOT NULL,
	entrega_id  SERIAL NOT NULL,
	descricao   TEXT NOT NULL,
	data_registro  DATE NOT NULL,
	PRIMARY KEY (id)
	);

	alter table ocorrencia add constraint fk_ocorrencia_entrega
	foreign key (entrega_id) references entrega (id);