# Xây dựng API bán mỹ phẩm ORI Shop

## Mô tả 

Phần Backend của dự án Xây dựng app mobile mua mỹ phẩm Ori Shop được xây dựng bằng Spring Boot, là một framework Java phổ biến cho việc phát triển ứng dụng web,app mobile. Phần này chịu trách nhiệm xử lý các yêu cầu từ phía app, quản lý dữ liệu và cung cấp các API cho phần giao diện người dùng.

## Cài đặt và kiểm thử
1. Clone project từ github:
```bash
https://github.com/galaticwarrior123/API_Cosmetic_AppMoblie_Project.git
```
2. Mở terminal và di chuyển đến thu mục đã clone project:
```bash
cd API_Cosmetic_AppMoblie_Project
```
3. Cài đặt Maven dependencies:
```bash
mvn install
```
4. Thiết lập cấu hình cơ sở dữ liệu:Chỉnh sửa file application.properties trong thư mục src/main/resources để cấu hình kết nối đến cơ sở dữ liệu PostgreSQL:
```bash
spring.datasource.url=jdbc:postgresql://dpg-cobavs4f7o1s73e1e6kg-a.singapore-postgres.render.com:5432/cosmetic_mobile_app
spring.datasource.username=root
spring.datasource.password=S1mfCVSKtm42xPvm9vluSjfj5j2juqBa
```
5. Kiểm thử ứng dụng
```bash
mvn spring-boot:run
```

## Công nghệ sử dụng
- Backend: 
    - Spring Boot để xây dựng API cho ứng dụng.
    - Spring Data JPA: Cung cấp một cách thuận tiện để truy cập và lưu trữ dữ liệu trong cơ sở dữ liệu.
    - Spring Security: Sử dụng để quản lý xác thực và ủy quyền người dùng.
    - JWT (JSON Web Tokens): Được sử dụng để xác thực và ủy quyền người dùng.
    - Bcrypt: Sử dụng để mã hóa mật khẩu người dùng.
- Database: PostgreSQL được sử dụng để lưu trữ thông tin về các tác phẩm văn học và người dùng.