-- # create databases
CREATE DATABASE IF NOT EXISTS `prestador`;
CREATE DATABASE IF NOT EXISTS `consumidor`;
CREATE DATABASE IF NOT EXISTS `agendamento`;
CREATE DATABASE IF NOT EXISTS `avaliacao`;
CREATE DATABASE IF NOT EXISTS `chat`;
CREATE DATABASE IF NOT EXISTS `pagamento`;

-- # create root user and grant rights
GRANT ALL ON `prestador`.* TO 'user'@'%';
GRANT ALL ON `consumidor`.* TO 'user'@'%';
GRANT ALL ON `agendamento`.* TO 'user'@'%';
GRANT ALL ON `avaliacao`.* TO 'user'@'%';
GRANT ALL ON `chat`.* TO 'user'@'%';
GRANT ALL ON `pagamento`.* TO 'user'@'%';
