import csv
from typing import Iterable
from models import RecipientMonthModel


class CsvFileReader:

    def __init__(self):
        pass

    @staticmethod
    def read_file(path: str) -> Iterable[RecipientMonthModel]:
        with open(path, mode='r', encoding='utf-8', errors='ignore') as csv_file:
            csv_reader = csv.reader(csv_file, delimiter=";")
            next(csv_file)
            for row in csv_reader:
                yield RecipientMonthModel(row)
