# Çalışan Yönetim Sistemi

Çalışan Yönetim Sistemi, şirket içindeki çalışanları yönetmek amacıyla tasarlanmış bir web uygulamasıdır.

## İçindekiler

- [Kurulum](#kurulum)
  - [Gereksinimler](#gereksinimler)
  - [Kurulum Adımları](#kurulum-adımları)
- [API Kullanımı](#api-kullanımı)
  - [Çalışan Ekleme](#1-çalışan-ekleme)

## Kurulum

### Gereksinimler

- Java 8 veya üstü
- MySQL veritabanı

### Kurulum Adımları

1. Proje dosyalarını indirin veya klonlayın.
2. MySQL veritabanını oluşturun ve bağlantı bilgilerini `application.properties` dosyasında güncelleyin.
3. Uygulamayı başlatmak için terminal veya komut istemcisine şu komutu yazın: `./mvnw spring-boot:run` veya istediğiniz bir IDE'de SpringBootCrudExampleApplication dosyasını çalıştırın.

## API Kullanımı

**Örnek olarak çalışan üzerinden anlatım yaptım fakat "employee"i "company" ile değiştirdiğiniz vakit şirket için gerekli CRUD işlemlere ulaşabilirsiniz.**


### 1. Çalışan Ekleme

- **Endpoint:** `POST /addEmployee`
- **Örnek İstek:**
  ```json
  {
    {
    "name": "Mehmet Oz",
    "company": {
        "id": 2
    }
  }
  
  ```
  
### 2. Birden Fazla Çalışan Ekleme
- **Endpoint:** `POST /addEmployees`
- **Örnek İstek:**
- ```json
  [
    {
      "name":"Ali Dalkilic",
      "company":{
        "id":2
      }
    },
    {
      "name":"Fettah Basdemir",
      "company":{
        "id":1
      }
    }
  ]
  ```
### 3. Çalışanları Getirme
-**EndPoint:** `GET /employees`

### 4. Çalışan Silme
-**Endpoint:** `DELETE /deleteEmployee/{id}`
- **Bur kısımda {} silinmeli ve "id" direkt olarak girilmeli**
- **Örnek İstak:**
- ```
  DELETE /deleteEmployee/3
  ```
