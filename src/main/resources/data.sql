INSERT INTO usuario (id, email, habilitado, nome, senha, tipo) VALUES (null, "gabriel@gmail.com", 1, "Gabriel", "1234bgg", "USUARIO"), (null, "romario@gmail.com", 1, "Romário", "romarin", "ADMINISTRADOR"), (null, "bernas@gmail.com", 1, "Bernardo", "senhaboa123", "USUARIO");
INSERT INTO turma (id, nome) VALUES (null, "MI 73"), (null, "MI 74"), (null, "MI 75");
INSERT INTO ambiente (id, nome) VALUES (null, "W 206"), (null, "W 207"), (null, "W 208");
INSERT INTO tipo_dispositivo (id, nome) VALUES (null, "Tablet"), (null, "VR"), (null, "Webcam");
INSERT INTO dispositivo (id, descricao, habilitado, marca, modelo, numero, tipo_id) VALUES (null, "Tablet Samsung", 1, "Samsung", "C3", 1, 1), (null, "Meta Quest", 1, "Meta", "Quest", 2, 2), (null, "Webcam Logitech", 1, "Logitech", "C200", 3, 3);
INSERT INTO periodo (id, inicio, fim, nome) VALUES (null, "07:30:00", "11:30:00", "Matutino"), (null, "12:30:00", "16:30:00", "Vespertino"), (null, "18:00:00", "22:00:00", "Noturno");
