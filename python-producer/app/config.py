import os


class Config:

    def __init__(self):
        self.file_path = '201901_BolsaFamilia_Pagamentos_preview.csv'
        self.kafka_connection = 'kafka1:9092'
        self.kafka_recipient_topic = 'recipient_topic'


class LocalConfig(Config):
    pass


class DockerConfig(Config):

    def __init__(self):
        super().__init__()
        self.file_path = '201901_BolsaFamilia_Pagamentos.csv'
        self.kafka_connection = 'kafka1:9092'


_config = LocalConfig()


try:
    if os.environ['ENV'] == 'local':
        _config = LocalConfig()
    if os.environ['ENV'] == 'docker':
        _config = DockerConfig()
except Exception:
    pass


def get_config():
    return _config
