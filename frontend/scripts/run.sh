#!/bin/bash

java -jar frontend/target/frontend-1.0.0-fat.jar -cluster -cluster-host 127.0.0.1 -Djava.net.preferIPv4Stack=true
