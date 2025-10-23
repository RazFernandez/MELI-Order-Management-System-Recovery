# 🚀 Spring Boot Startup Script Guide  
Easily start your application in **development** or **production** mode.

---

## 🧩 1. Configure Profiles

### Create the following files inside `src/main/resources/`

#### 📄 `application.yml`
```yaml
spring:
  profiles:
    active: dev  # default profile
```

#### 📄 `application-dev.yml`
```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

#### 📄 `application-prod.yml`
```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/meli_db
    driver-class-name: org.postgresql.Driver
    username: your_user
    password: your_password
  jpa:
    hibernate:
      ddl-auto: none
    show-sql: false
```

---

## 🖥️ 2. Linux / macOS Script

### Create a file named:
```
start-app.sh
```

### Paste this inside:
```bash
#!/bin/bash

echo "🚀 Starting Meli App..."

# Default to 'dev' mode if not specified
MODE=${1:-dev}

# Validate mode
if [[ "$MODE" != "dev" && "$MODE" != "prod" ]]; then
  echo "❌ Invalid mode: $MODE"
  echo "Usage: ./start-app.sh [dev|prod]"
  exit 1
fi

# Set environment variable
export SPRING_PROFILES_ACTIVE=$MODE

# Optional: create and clean logs folder
LOG_FILE="logs/app.log"
mkdir -p logs
rm -f $LOG_FILE

echo "🌱 Environment: $MODE"
echo "📝 Logs: $LOG_FILE"
echo "----------------------------------"

# Run the app
mvn spring-boot:run -Dspring-boot.run.profiles=$MODE | tee $LOG_FILE
```

### Make it executable:
```bash
chmod +x start-app.sh
```

### Run it:
```bash
./start-app.sh        # Development mode
./start-app.sh prod   # Production mode
```

---

## 🪟 3. Windows Script

### Create a file named:
```
start-app.bat
```

### Paste this inside:
```bat
@echo off
set MODE=%1
if "%MODE%"=="" set MODE=dev

if not "%MODE%"=="dev" if not "%MODE%"=="prod" (
    echo ❌ Invalid mode: %MODE%
    echo Usage: start-app.bat [dev|prod]
    exit /b 1
)

echo 🚀 Starting Meli App in %MODE% mode...
set SPRING_PROFILES_ACTIVE=%MODE%

if not exist logs mkdir logs
del /q logs\app.log >nul 2>&1

echo 🌱 Environment: %MODE%
echo 📝 Logs: logs\app.log
echo ----------------------------------

call mvn spring-boot:run -Dspring-boot.run.profiles=%MODE%
```

### Run it:
```bash
start-app.bat        # Development mode
start-app.bat prod   # Production mode
```

---

## ✅ 4. Verify Profile

Once the app starts, check your logs:
```
Active profile(s): dev
```
or  
```
Active profile(s): prod
```

---

## 🧠 Tips

- Development uses **H2** (in-memory DB)  
- Production uses **PostgreSQL**
- Logs are saved under `/logs/app.log`
- You can change ports or credentials easily in the `.yml` files

---

🎯 **Now you can start your app in seconds:**
```bash
./start-app.sh
# or
./start-app.sh prod
```
