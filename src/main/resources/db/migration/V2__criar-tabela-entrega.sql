CREATE TABLE entrega(

    id SERIAL NOT NULL,
    cliente_id SERIAL NOT NULL,
    taxa DECIMAL(10,2) NOT NULL,
    status varchar(20) NOT NULL,
    data_pedido DATE NOT NULL,
    data_finalizacao DATE NOT NULL,

    destinatario_nome varchar (60) NOT NULL,
    destinatario_logradouro varchar (255) NOT NULL,
    destinatario_numero varchar (30) NOT NULL,
    destinatario_complemento varchar (60) NOT NULL,
    destinatario_bairro varchar (30) NOT NULL,

    PRIMARY KEY(id)
);

ALTER TABLE entrega ADD CONSTRAINT fk_entrega_cliente FOREIGN KEY (cliente_id) REFERENCES CLIENTE (id)