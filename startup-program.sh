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
