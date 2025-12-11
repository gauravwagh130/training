FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy only src files
COPY src/main/java /app

# Compile the Java file (inside package)
RUN javac com/java/training/HelloWorld.java

# Run the main class with package name
CMD ["java", "com.java.training.HelloWorld"]
