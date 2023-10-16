-- Exclui a tabela "consulta" se já existir
DROP TABLE IF EXISTS consulta;

-- Cria a tabela "consulta"
CREATE TABLE consulta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomePaciente VARCHAR(255),
    nomeMedico VARCHAR(255),
    especialidade VARCHAR(255),
    local VARCHAR(255)
);

-- Insere alguns registros de exemplo
INSERT INTO consulta (nomePaciente, nomeMedico, especialidade, local) VALUES
('Paciente 1', 'Médico 1', 'Cardiologia', 'Sala 101'),
('Paciente 2', 'Médico 2', 'Ortopedia', 'Sala 102'),
('Paciente 3', 'Médico 3', 'Ginecologia', 'Sala 103');