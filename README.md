### 🚀 Selecione o perfil do app

- prd
- hml
- dev = default

```
bootRun --args='--spring.profiles.active=prd'
```

### 🚀 Start/Down ambiente local

```
docker-compose -f devops/docker-compose.yaml up -d --build
```

```
docker-compose -f devops/docker-compose.yaml up down
```

### 📌 Acessar app local

#### 🌏 App

- ```
  http://localhost:8081/api
  ```

#### 🌏 OpenApi UI

- ```
  http://localhost:8081/api/swagger-ui/index.html#/
  ```

#### 🌏 OpenApi API

- ```
  http://localhost:8081/api/v3/api-docs
  ```

### ⛓️ Metricas

#### 🌏 Requests

- ```
  http://localhost:8081/api/actuator
  ```
