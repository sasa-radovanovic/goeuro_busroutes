#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
RUN="java -jar "$DIR"/target/goeuro_busroutes-0.0.1-SNAPSHOT-jar-with-dependencies.jar"
DATA_FILE=$2
start() {	
    pkill java
    PID=$!
    local CMD="$RUN $DATA_FILE &" 
    { sleep 1; $CMD &> /dev/null; return 1;} & 
}
stop() {
    pkill java
}
case $1 in
    start)
        start
        ;;
    stop)
        stop
        ;;
    block)
        start
        sleep infinity
        ;;
    *)
        echo "Usage: $0 {start|stop|block} DATA_FILE"
esac
