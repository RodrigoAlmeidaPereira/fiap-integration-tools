from config import get_config
from file_reader import CsvFileReader
from producers import RecipientMonthProducer


if __name__ == '__main__':
    print('Producer stated')

    cfg = get_config()
    reader = CsvFileReader()
    producer = RecipientMonthProducer()

    for recipient_month in reader.read_file(cfg.file_path):
        producer.produce(cfg.kafka_recipient_topic, recipient_month)
