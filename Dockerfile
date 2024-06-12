# ベースイメージとしてJDKを使用
FROM openjdk:11-jdk-slim

# 作業ディレクトリの設定
WORKDIR /app

# Mavenの依存関係を先にコピーしてキャッシュを利用
COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

# プロジェクトのソースコードをコピー
COPY src ./src

# プロジェクトをビルド
RUN ./mvnw clean package -DskipTests

# 実行
CMD ["java", "-jar", "target/my-springboot-project-0.0.1-SNAPSHOT.jar"]
