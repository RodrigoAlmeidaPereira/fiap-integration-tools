from config import Config
from file_reader import CsvFileReader


if __name__ == '__main__':
    print('Producer stated')

    cfg = Config()
    reader = CsvFileReader()
    for index, rec in enumerate(reader.read_file(cfg.file_path)):
        print(f'{index} - {rec}')
