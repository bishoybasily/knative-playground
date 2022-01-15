#!/bin/bash

java -jar backend/target/backend-1.0.0-fat.jar -cluster -cluster-host 127.0.0.1 -Djava.net.preferIPv4Stack=true
