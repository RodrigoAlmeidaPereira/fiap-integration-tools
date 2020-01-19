FROM python:3

LABEL maintainer="Rodrigo de Almeida Pereira <rodrigoalmeida.as@gmail.com>"

COPY requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt

COPY app /app

WORKDIR app

ENTRYPOINT python3 -u main.py
