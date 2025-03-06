# 

## Model
www.msaez.io/#/30834810/storming/phonelostservice

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- lostphonereport
- phonemanagement
- notification
- devicerecovery
- phonerental
- servicemanagement


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- lostphonereport
```
 http :8088/lostPhoneReports id="id"userId="userId"deviceId="deviceId"status="status"reportedAt="reportedAt"
```
- phonemanagement
```
 http :8088/devices id="id"userId="userId"model="model"status="status"locked="locked"registeredAt="registeredAt"updatedAt="updatedAt"
 http :8088/remoteLocks id="id"deviceId="deviceId"status="status"lockedAt="lockedAt"
```
- notification
```
 http :8088/notifications id="id"userId="userId"message="message"status="status"sentAt="sentAt"
```
- devicerecovery
```
 http :8088/recoveries id="id"userId="userId"deviceId="deviceId"recoveredAt="recoveredAt"status="status"
```
- phonerental
```
 http :8088/rentals id="id"userId="userId"deviceModel="deviceModel"status="status"rentalStartDate="rentalStartDate"expectedReturnDate="expectedReturnDate"
```
- servicemanagement
```
 http :8088/imeiBlocks id="id"deviceId="deviceId"imeiNumber="imeiNumber"status="status"blockedAt="blockedAt"deviceId="deviceId"imeiNumber="imeiNumber"status="status"blockedAt="blockedAt"
 http :8088/usimBlocks id="id"deviceId="deviceId"status="status"blockedAt="blockedAt"deviceId="deviceId"status="status"blockedAt="blockedAt"
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
