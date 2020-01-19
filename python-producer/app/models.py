import json
from collections import namedtuple


DateMonth = namedtuple('DateMonth', ['month', 'year'])


class RecipientMonthModel:

    REFERENCE_MONTH_INDEX = 0
    COMPETENCE_MONTH_INDEX = 1
    UF_INDEX = 2
    CITY_CODE_INDEX = 3
    CITY_NAME_INDEX = 4
    RECIPIENT_NIS_INDEX = 5
    RECIPIENT_NAME_INDEX = 6
    INSTALLMENT_VALUE_INDEX = 7

    def __init__(self, fields):
        self.reference_month = DateMonth(year=fields[self.REFERENCE_MONTH_INDEX][:4],
                                         month=fields[self.REFERENCE_MONTH_INDEX][4:])
        self.competence_month = DateMonth(year=fields[self.COMPETENCE_MONTH_INDEX][:4],
                                          month=fields[self.COMPETENCE_MONTH_INDEX][4:])
        self.uf = fields[self.UF_INDEX]
        self.city_code = fields[self.CITY_CODE_INDEX]
        self.city_name = fields[self.CITY_NAME_INDEX]
        self.recipient_nis = fields[self.RECIPIENT_NIS_INDEX]
        self.recipient_name = fields[self.RECIPIENT_NAME_INDEX]
        self.installment_value = fields[self.INSTALLMENT_VALUE_INDEX]

    def __str__(self):
        return f'{str(self.__class__)}: {str(self.__dict__)}'

    def __repr__(self):
        keys = ', '.join(f'{k}={v}' for k, v in vars(self).items())
        return f'{self.__class__.__name__}({keys})'

    def to_json(self):
        return json.dumps(self.__dict__)
