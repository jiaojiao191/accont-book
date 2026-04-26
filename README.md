# 记账本应用 (Account Book)

一个基于前后端分离架构的简单记账本应用，支持记录收入和支出账单。

## 📋 项目简介

这是一个全栈记账本应用，帮助用户轻松管理个人财务。用户可以添加、查看和删除账单记录，支持区分收入和支出两种类型，并可以添加分类和备注信息。

## 🛠️ 技术栈

### 后端技术
- **Spring Boot** 4.0.6 - Java Web 框架
- **Java** 21 - 编程语言
- **Spring Data JPA** - 数据持久层框架
- **MySQL** - 关系型数据库
- **Lombok** - 简化 Java 代码的工具

### 前端技术
- **Vue 3** 3.5.32 - 渐进式 JavaScript 框架
- **Vite** 8.0.10 - 现代前端构建工具
- **Vue Router** 4.6.4 - Vue.js 官方路由管理器
- **Pinia** 3.0.4 - Vue 状态管理库
- **Axios** 1.15.2 - HTTP 客户端

## 📁 项目结构

```
account-book/
├── backend/                    # 后端项目
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/backend/
│   │   │   │       ├── BackendApplication.java    # Spring Boot 启动类
│   │   │   │       ├── config/                     # 配置类
│   │   │   │       │   ├── ForwardController.java  # 路由转发控制器
│   │   │   │       │   └── WebMvcConfig.java       # Web MVC 配置
│   │   │   │       ├── controller/                 # 控制器层
│   │   │   │       │   └── BillController.java     # 账单控制器
│   │   │   │       ├── entity/                     # 实体类
│   │   │   │       │   └── Bill.java               # 账单实体
│   │   │   │       ├── repository/                 # 数据访问层
│   │   │   │       │   └── BillRepository.java     # 账单仓库
│   │   │   │       └── service/                    # 业务逻辑层
│   │   │   │           └── BillService.java        # 账单服务
│   │   │   └── resources/                          # 资源文件
│   │   └── test/                                   # 测试代码
│   └── pom.xml                                     # Maven 配置文件
│
└── frontend/                   # 前端项目
    ├── src/
    │   ├── api/                                    # API 接口
    │   │   └── bill.js                             # 账单相关 API
    │   ├── assets/                                 # 静态资源
    │   ├── components/                             # 组件
    │   ├── router/                                 # 路由配置
    │   │   └── index.js                            # 路由定义
    │   ├── utils/                                  # 工具函数
    │   ├── views/                                  # 页面视图
    │   │   └── BillList.vue                        # 账单列表页面
    │   ├── App.vue                                 # 根组件
    │   └── main.js                                 # 入口文件
    ├── index.html                                  # HTML 模板
    ├── package.json                                # Node.js 依赖配置
    └── vite.config.js                              # Vite 配置文件
```

## ✨ 功能特性

- ✅ 添加账单记录（收入/支出）
- ✅ 查看所有账单列表
- ✅ 删除账单记录
- ✅ 按类型分类（收入/支出）
- ✅ 支持账单分类和备注
- ✅ 自动记录创建时间

## 🚀 快速开始

### 环境要求

- **JDK** 21 或更高版本
- **Node.js** 18 或更高版本
- **MySQL** 5.7 或更高版本
- **Maven** 3.6 或更高版本

### 安装步骤

#### 1. 克隆项目

```bash
git clone <repository-url>
cd account-book
```

#### 2. 配置数据库

在 MySQL 中创建数据库：

```sql
CREATE DATABASE account_book DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

修改后端配置文件 `backend/src/main/resources/application.properties`（或 `application.yml`），配置数据库连接信息：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/account_book?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

#### 3. 启动后端服务

```bash
cd backend
mvn spring-boot:run
```

后端服务将在 `http://localhost:8080` 启动。

#### 4. 启动前端服务

打开新的终端窗口：

```bash
cd frontend
npm install
npm run dev
```

前端服务将在 `http://localhost:5173` 启动（具体端口以实际输出为准）。

## 📖 API 接口

### 账单相关接口

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/api/bills` | 获取所有账单列表 |
| POST | `/api/bills` | 创建新账单 |
| DELETE | `/api/bills/{id}` | 删除指定账单 |

### 请求/响应示例

**创建账单**

```json
POST /api/bills
{
  "amount": 100.50,
  "type": 0,
  "category": "餐饮",
  "remark": "午餐"
}
```

**响应**

```json
{
  "id": 1,
  "amount": 100.50,
  "type": 0,
  "category": "餐饮",
  "remark": "午餐",
  "createTime": "2024-01-01T12:00:00"
}
```

## 💡 使用说明

1. **添加账单**：在首页表单中输入金额、选择类型（收入/支出）、填写分类和备注，点击"添加"按钮
2. **查看账单**：账单列表会自动显示所有记录，包含类型、金额、分类、备注和时间
3. **删除账单**：点击每条账单右侧的"删除"按钮，确认后即可删除

## 🔧 开发指南

### 后端开发

- 实体类位于 `backend/src/main/java/com/example/backend/entity/`
- 控制器位于 `backend/src/main/java/com/example/backend/controller/`
- 服务层位于 `backend/src/main/java/com/example/backend/service/`
- 数据访问层位于 `backend/src/main/java/com/example/backend/repository/`

### 前端开发

- 页面组件位于 `frontend/src/views/`
- API 接口封装位于 `frontend/src/api/`
- 路由配置位于 `frontend/src/router/`
- 通用组件位于 `frontend/src/components/`

## 📝 注意事项

- 首次启动时，JPA 会自动创建数据库表结构
- 确保后端服务启动后再启动前端服务
- 前端通过 Axios 代理请求后端 API，需确保跨域配置正确
- 在生产环境中，建议配置 HTTPS 和更强的安全措施

## 🤝 贡献指南

欢迎提交 Issue 和 Pull Request 来改进这个项目！

## 📄 许可证

本项目采用 MIT 许可证。

## 👨‍💻 作者

由开发者创建，用于学习和实践前后端分离开发技术。
