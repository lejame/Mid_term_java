# Mid_term_java
### Tóm Tắt

- [I. Mô Tả](#mo-ta)
- [II. Sơ Đồ Mối Quan Hệ Thực Thể](#sơ-đồ-mối-quan-hệ-thực-thể)
- [III. Cấu Trúc](#cấu-trúc)
- [IV. Cách Chạy Dự Án](#cách-chạy-dự-án)
- [V. Sử Dụng APIs](#sử-dụng-apis)
- [VI. Demo](#demo)

## I. Mô Tả <a name="mo-ta"></a>
Đầu tiên thì em xin giải thích phần mềm của mình là 1 trang web bán điện thoại , sẽ có các tính năng đơn giản như là đăng nhập, đăng kí, thêm vào giỏ hàng , quản lấy sản phẩm.
## II.Sơ đồ mối quan hệ thực thể <a name="sơ-đồ-mối-quan-hệ-thực-thể"></a>
![](/Diagram_Values/mohinh.mdj)
## III.Cấu Trúc <a name="cấu-trúc"></a>

### 1.Backend

#### Controller 
- `AdminController.java`: Quản lý chức năng của admin.
- `CartController.java`: Quản lý giỏ hàng và thanh toán
- `HomeController.java`: Điều khiển các hoạt động liên quan đến trang chủ của website, bao gồm việc hiển thị thông tin chung hoặc lọc nhưng không có tài khoản người dùng
- `DetailController.java`: Hiển thị các hoạt động của người dùng, hiển thị sản phẩm
- `LoginController.java`: Xử lý các yêu cầu đăng nhập của người dùng, kiểm tra thông tin đăng nhập, xác thực và điều hướng người dùng sau khi đăng nhập thành công.

#### Model
- `Model_Account.java`, `Model_Caterory.java`, `Model_Phone.java`,`Model_Phone_Brand.java`, `Model_UserShoppingCart.java`: Định nghĩa các đối tượng dữ liệu.


#### Repository
- `CartRepository.java`, `CateroryRepository.java`,`Home_Product.java`,`ManagementProductRepository.java`,`ModelPhoneBrandRepository.java`,`UserRepository.java`,,`UserShoppingRepository.java` : Truy cập và tương tác với cơ sở dữ liệu.

#### Service
- `AdminService.java`, `CartService.java` ,`HomeProductService.java`,`LoginService.java`,`ProductService.java`: Logic xử lý nghiệp vụ.

#### `MidtermApplication.java`
Điểm khởi đầu của ứng dụng Spring Boot.

### 2.Frontend

#### Static
- `css`, `js`: Tài nguyên tĩnh.

#### Template
- `AdminHome.html`, `Cart.html`,`Detail.html`,`DetailNoUser.html`,`Error.html`,`Home.html`,`Login.html`,`ManagementProduct.html`,`Register.html`,`update.html`,`UserHome.html`: Giao diện các trang.

## IV.Cách Chạy Dự Án <a name="cách-chạy-dự-án"></a>
Trước tiên khi tải ứng dụng về thì phải tạo 1 databse có thên là phone_management
Trong file Diagram_Values có mô hình quan hệ và các giá trị để insert vào trong database phone_managemnt
Sau khi hoàn thành việc tạo database và thêm dữu liệu thì có thể chạy được chương trình.

## V.Sử Dụng APIs  <a name="sử-dụng-apis"></a>

### 1.AdminController:

| Endpoint                     | Method | Request Body Key | Description                                      |
|------------------------------|--------|------------------|--------------------------------------------------|
| /phone_management/{username} | GET    | N/A              | Hiển thị trang quản trị                          |
| /phone_management/{name}     | POST   | N/A              | Hiển thị form thêm sản phẩm mới                  |
| /phone/delete/{id}           | POST   | Various          | Xóa sản phẩm mới từ dữ liệu form                 |
| /phone/edit/{id}             | GET    | N/A              | Hiển thị thông tin sản phẩm để chỉnh sửa theo id |
| /phone/edit/{id}             | GET    | N/A              | chỉnh sửa sản phẩm theo ID                       |
| /phone/Reload/{id}           | POST   | Various          | Reload thông tin sản phẩm từ dữ liệu form        |

### 2.Cart Controller:

| Endpoint                               | Method | Request Body Key | Description                                    |
|----------------------------------------|--------|------------------|------------------------------------------------|
| `/addToCart/{id}/{quantity}/{name}`    | GET    | N/A              | thêm sản phẩm của người dùng vào giỏ hàng      |
| `/cart/{name}`                         | GET    | N/A              | Hiển thị giỏ hàng của người dùng               |
| `/update/{id_phone}/{name}/{quantity}` | POST   | N/A              | Cập nhật số lượng một sản phẩm  của người dùng |
| `/delete/{id_phone}/{name}/{quantity}` | GET    | N/A              | xóa số lượng sản phẩm trong giỏ hàng           |
| `/btn_delete/{id}/{name}`              | GET    | N/A              | xóa sản phẩm trong giỏ hàng                    |

### 3.Detail Controller:

| Endpoint                         | Method         | Request Params | Description                                                |
|----------------------------------|----------------|----------------|------------------------------------------------------------|
| `/detailProduct/{username}/{id}` | RequestMapping | N/A            | Hiển thị danh sách tất cả sản phẩm theo tên của người dùng |
| `/detailProduct/{id}`            | RequestMapping |                | Hiển thị thông tin chi tiết sản phẩm                       |

### 4.Home Controller:
| Endpoint                           | Method | Request Params | Description                                                                                 |
|------------------------------------|--------|----------------|---------------------------------------------------------------------------------------------|
| `/home`                            | GET    |                | Hiển thị danh sách sản phẩm cho người dùng chưa đăng nhập                                   |
| `/home/{name}`                     | GET    | N/A            | Hiển thị danh sách sản phẩm cho người dùng đã đăng nhập                                     |
| `/home/search`                     | GET    |                | Hiển thị danh sách sản phẩm mà người dùng chưa đăng nhập tìm kiếm theo tên                  |
| `/home/search_all`                 | GET    |                | Hiển thị danh sách sản phẩm mà người dùng chưa đăng nhập tìm kiếm theo loại mẫu và giá tiền |
| `/home/search_user/{user}`         | GET    |                | Hiển thị danh sách sản phẩm mà người dùng đã đăng nhập tìm kiếm theo tên                    |
| `/home/search_all_user/{username}` | GET    |                | Hiển thị danh sách sản phẩm mà người dùng đã đăng nhập tìm kiếm theo loại mẫu và giá tiền |
| `/home/search_admin/{user}`         | GET    |                | Hiển thị danh sách sản phẩm mà người dùng đã đăng nhập bằng Admin tìm kiếm theo tên                    |
| `/home/search_all_admin/{username}` | GET    |                | Hiển thị danh sách sản phẩm mà người dùng đã đăng nhập bằng Admin tìm kiếm theo loại mẫu và giá tiền |

### 5.Login Controller

| Endpoint    | Method | Request Params | Description                                  |
|-------------|--------|----------------|----------------------------------------------|
| `/login`    | GET    | N/A            | Hiển thị trang đăng nhập                     |
| `/user_login` | POST   |  | Kiểm tra thông tin đăng nhập và chuyển hướng |
| `/register` | GET   |  | Hiển thị trang đăng kí |
| `/user_register` | POST   |  | Kiểm tra thông tin đăng kí và chuyển hướng |


## VI.Demo <a name="demo"></a>
 
![Bấm vào đây để xem]()