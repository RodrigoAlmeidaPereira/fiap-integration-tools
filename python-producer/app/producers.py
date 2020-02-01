from config import get_config
from kafka import KafkaProducer
from models import RecipientMonthModel


def _on_send_success(record_metadata):
    print(f'SENT TO {record_metadata.topic} - PARTITION {record_metadata.partition} - OFFSET {record_metadata.offset}')


def _on_send_error(excp):
    print(f'I am an errback {excp}')


class RecipientMonthProducer:

    def __init__(self):
        self._config = get_config()
        self._producer = KafkaProducer(bootstrap_servers=self._config.kafka_connection)

    def produce(self, topic: str, recipient_model: RecipientMonthModel):
        self._producer.send(topic, recipient_model.to_json().encode(), partition=0,
                            headers=[('type', 'count'.encode())])\
            .add_callback(_on_send_success)\
            .add_errback(_on_send_error)

        self._producer.flush()

        