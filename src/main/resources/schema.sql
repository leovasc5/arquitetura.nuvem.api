-- Criação da tabela Cliente
CREATE TABLE Cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Criação da tabela Entrega
CREATE TABLE Entrega (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_rastreamento VARCHAR(50) UNIQUE NOT NULL,
    id_cliente BIGINT NOT NULL,
    endereco_origem VARCHAR(255) NOT NULL,
    endereco_destino VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_previsao_entrega TIMESTAMP,
    status VARCHAR(50) DEFAULT 'PENDENTE',
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
);

-- Criação da tabela EventoRastreamento
CREATE TABLE EventoRastreamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_entrega BIGINT NOT NULL,
    status VARCHAR(50) NOT NULL,
    data_evento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    localizacao VARCHAR(255),
    descricao VARCHAR(255),
    FOREIGN KEY (id_entrega) REFERENCES Entrega(id)
);
