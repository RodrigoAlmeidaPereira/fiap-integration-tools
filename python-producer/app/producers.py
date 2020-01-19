from config import get_config
from kafka import KafkaProducer
from models import RecipientMonthModel


class RecipientMonthProducer:

    def __init__(self):
        self._config = get_config()
        self._producer = KafkaProducer(bootstrap_servers=self._config.kafka_connection)

    def produce(self, topic: str, recipient_model: RecipientMonthModel):
        self._producer.send(topic, recipient_model.to_json().encode())
        print(f'sent {recipient_model.to_json().encode()}')
