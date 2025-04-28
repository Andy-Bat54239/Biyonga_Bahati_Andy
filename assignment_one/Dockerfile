FROM eclipse-temurin:22-jdk-jammy

WORKDIR /app

COPY src ./src

RUN find src -name "*.java" > sources.txt \
    && javac @sources.txt -d out

COPY launcher.sh .

RUN chmod +x launcher.sh

CMD ["./launcher.sh"]
