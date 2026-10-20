# openatom-recruit-tasks

2026 开放原子工作室后端方向招新题（第 1–8 题）的 Java 实现。

- 全部题目均使用**课程范围内**的基础知识实现：基本语法、控制流、面向对象、异常、集合、字节流 I/O、多线程同步，没有使用线程池、Stream、注解、反射等超纲 API。
- 每个题目一个独立的包，包内分为「实体/工具类」和「演示主类（含 main）」两类文件，便于逐个运行对照题目示例输出。
- 项目使用标准 Maven 目录结构（`src/main/java`），但**不依赖任何第三方库**，直接用 `javac` / `java` 也能编译运行。

> 原题原文存档见 [`docs/题目原文-第1-8题.md`](docs/题目原文-第1-8题.md)。

---

## 一、环境搭建（对应第 1 题 Task1）

1. 安装 JDK（本工程使用 **JDK 21**，编译级别设为 17，JDK 17 及以上均可运行），安装 IntelliJ IDEA。
2. 配置环境变量：
   - `JAVA_HOME` = `C:\Program Files\Java\jdk-21.0.12.1`（按实际安装路径填写，不要带 `\bin`）
   - `Path` 中新增 `%JAVA_HOME%\bin`
3. 打开终端验证：

```text
> java -version
java version "21.0.12.1" 2026-08-18 LTS
Java(TM) SE Runtime Environment (build 21.0.12.1+1-LTS-4)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.12.1+1-LTS-4, sharing)

> javac -version
javac 21.0.12.1
```

4. 用 IDEA 打开本项目根目录（识别 `pom.xml`），Project SDK 选择 JDK 17 及以上即可。

---

## 二、项目目录结构

```text
openatom-recruit-tasks
├── pom.xml                               # 仅声明 JDK 版本，无第三方依赖
├── README.md
├── .gitignore
├── docs
│   └── 题目原文-第1-8题.md                 # 题目原文存档，便于对照题意
└── src/main/java/com/openatom/recruit
    ├── task01                            # 第 1 题：环境搭建与程序运行
    │   ├── HelloWorld.java               #   主类（main）
    │   └── GreetingService.java          #   问候服务类
    ├── task02                            # 第 2 题：数据类型与运算符
    │   ├── ProductBilling.java           #   商品核算（main）
    │   └── VariableSwapper.java          #   变量交换（main）
    ├── task03                            # 第 3 题：控制流综合特训
    │   ├── ToolboxApp.java               #   工具箱菜单 + 递归阶乘（main）
    │   ├── ScoreEvaluator.java           #   if-else / switch 成绩评定
    │   └── PyramidPrinter.java           #   空心金字塔
    ├── task04                            # 第 4 题：面向对象（5 个小问）
    │   ├── encapsulation                 #   4.1 封装、构造器、静态成员
    │   │   ├── Product.java
    │   │   └── ProductDemo.java          #   main
    │   ├── inheritance                   #   4.2 继承、抽象类、接口、多态
    │   │   ├── GpsLocatable.java
    │   │   ├── TransportVehicle.java
    │   │   ├── Truck.java
    │   │   ├── Drone.java
    │   │   └── TransportDemo.java        #   main
    │   ├── generic                       #   4.3 泛型储物箱
    │   │   ├── StorageBox.java
    │   │   └── StorageBoxDemo.java       #   main
    │   ├── dynamicarray                  #   4.4 手写 MyArrayList
    │   │   ├── MyArrayList.java
    │   │   └── MyArrayListDemo.java      #   main
    │   └── pattern                       #   4.5 单例 / 工厂 / 建造者
    │       ├── LogisticsConfig.java
    │       ├── VehicleFactory.java
    │       ├── LogisticsOrder.java
    │       └── PatternDemo.java          #   main
    ├── task05                            # 第 5 题：异常与异常处理
    │   ├── InsufficientFundsException.java
    │   ├── SystemMaintenanceException.java
    │   ├── PaymentProcessor.java
    │   ├── PaymentService.java
    │   └── PaymentDemo.java              #   main
    ├── task06                            # 第 6 题：集合运用
    │   ├── Order.java
    │   ├── OrderAnalyzer.java
    │   └── OrderAnalyzerDemo.java        #   main
    ├── task07                            # 第 7 题：文件分片与合并
    │   ├── FileChunkTransfer.java
    │   └── FileTransferDemo.java         #   main
    └── task08                            # 第 8 题：线程同步
        ├── MilkTeaCounter.java           #   吧台（共享容器）
        ├── Staff.java                    #   店员线程
        ├── Customer.java                 #   顾客线程
        └── MilkTeaShopDemo.java          #   main
```

---

## 三、题目清单与代码位置

| 题号 | 题目 | 核心知识点 | 入口类（含 main） | 其余类 |
| --- | --- | --- | --- | --- |
| 1 | 环境搭建与程序运行 | 多文件/多类协同、经典 main 写法 | `task01.HelloWorld` | `GreetingService` |
| 2 | 数据类型与运算符 | 基本类型、算术/关系/逻辑运算、字符串拼接 | `task02.ProductBilling`、`task02.VariableSwapper` | — |
| 3 | 控制流综合特训 | while + break、if-else / switch、嵌套 for、递归 | `task03.ToolboxApp` | `ScoreEvaluator`、`PyramidPrinter` |
| 4.1 | 封装、构造与静态成员 | private 封装、构造器重载、static 成员 | `task04.encapsulation.ProductDemo` | `Product` |
| 4.2 | 继承、抽象类与接口 | extends / implements、抽象方法、protected、多态 | `task04.inheritance.TransportDemo` | `GpsLocatable`、`TransportVehicle`、`Truck`、`Drone` |
| 4.3 | 泛型容器特训 | 泛型类 `<T>`、类型安全 | `task04.generic.StorageBoxDemo` | `StorageBox` |
| 4.4 | 手写迷你 ArrayList | 数组扩容、复制、移位、向下转型 | `task04.dynamicarray.MyArrayListDemo` | `MyArrayList` |
| 4.5 | 三种设计模式 | 单例、简单工厂、建造者（静态内部类 + 链式调用） | `task04.pattern.PatternDemo` | `LogisticsConfig`、`VehicleFactory`、`LogisticsOrder` |
| 5 | 异常与异常处理 | 自定义受检/非受检异常、异常链、多重 catch、finally | `task05.PaymentDemo` | `InsufficientFundsException`、`SystemMaintenanceException`、`PaymentProcessor`、`PaymentService` |
| 6 | 集合运用 | List / Set / Map、Comparable、Comparator、去重分组排序 | `task06.OrderAnalyzerDemo` | `Order`、`OrderAnalyzer` |
| 7 | 文件操作 | FileInputStream / FileOutputStream、缓冲区、文件分片合并 | `task07.FileTransferDemo` | `FileChunkTransfer` |
| 8 | 线程同步 | Runnable、synchronized、wait / notifyAll | `task08.MilkTeaShopDemo` | `MilkTeaCounter`、`Staff`、`Customer` |

> 第 9–11 题为 SQL 与 Spring Boot 方向，不属于本次 Java 基础部分的存放范围，本工程未包含。

---

## 四、运行方式

### 方式一：IntelliJ IDEA（推荐）

1. `File → Open` 选择项目根目录 `openatom-recruit-tasks`，等待 Maven 导入完成；
2. 打开上表「入口类」对应的文件，点击 `main` 方法左侧的绿色三角运行；
3. 第 3 题为交互式程序，需在 Run 控制台中按菜单输入数字。

### 方式二：命令行（以项目根目录为当前目录）

Windows CMD：

```bat
:: 1. 生成源文件清单并编译到 out 目录
dir /s /b src\*.java > sources.txt
javac -encoding UTF-8 -d out @sources.txt

:: 2. 运行任意一题的入口类
java -cp out com.openatom.recruit.task01.HelloWorld
java -cp out com.openatom.recruit.task04.dynamicarray.MyArrayListDemo
```

Git Bash / macOS / Linux：

```bash
# 1. 编译
javac -encoding UTF-8 -d out $(find src -name "*.java")

# 2. 运行
java -cp out com.openatom.recruit.task08.MilkTeaShopDemo
```

运行第 3 题时可先准备输入文件，避免手动输入：

```bash
printf '1\n86\n2\n5\n3\n4\n4\n' | java -cp out com.openatom.recruit.task03.ToolboxApp
```

> 第 7 题运行时会在项目根目录下生成 `temp/file-demo/`（已加入 `.gitignore`），内含测试源文件与合并结果，可直接打开对比。

---

## 五、各题实现说明

### 第 1 题：环境搭建与程序运行

- `HelloWorld`：使用最经典的 `public static void main(String[] args)`，先打印 `Hello world`，再 `new GreetingService()` 并调用 `sayHello("OpenAtom")`，体现"主类 + 业务类"的多文件协同。
- `GreetingService#sayHello(String name)`：按题目要求输出 `Hello!`；`name` 为题目规定的入参，保留以便扩展为个性化问候。

```text
Hello world
Hello!
```

### 第 2 题：数据类型与运算符

- `ProductBilling`：声明 `String / double / int / boolean` 四种商品属性，用 `总价 = 单价 * 数量` 计算，再用 `totalPrice >= 100 || onPromotion` 判断包邮（短路或，左边为真时右边不再计算），全部用字符串 `+` 拼接输出。
- `VariableSwapper`：先用"加减法三步"交换 `a`、`b`（`a=a+b; b=a-b; a=a-b;`），再用异或 `^` 交换一次还原，验证两种不借助临时变量的思路。

```text
商品：机械键盘，单价：150.0元，促销中：false，购买2件，总价为：300.0元
是否享受包邮：true
售出后剩余库存：18件
交换前: a=10, b=20
交换后: a=20, b=10
异或方式再交换一次: a=10, b=20
```

### 第 3 题：控制流综合特训

- `ToolboxApp`：`while (true)` 常驻菜单，输入 `4` 时 `break`；菜单 1/2/3 分别调用成绩评定、金字塔打印与递归阶乘。`calculateFactorial` 为独立的 `public int` 递归方法（出口 `n <= 1` 返回 1）。
- `ScoreEvaluator`：`gradeByIfElse` 用区间判断；`gradeBySwitch` 用 `score / 10` 的整数取整特性把区间"压缩"成档位，体现 switch 适合"离散值匹配"、if-else 适合"范围判断"的区别。
- `PyramidPrinter`：外层控制行（`layer` 行），内层先打印 `layer - i` 个空格实现居中，再打印 `2*i-1` 个位置；只有第一行、最后一行、以及每行首尾位置打印 `*`，其余为空格，从而形成空心金字塔。

```text
【欢迎使用多功能工具箱】
1.成绩评定 2.空心金字塔 3.递归阶乘 4.退出系统
请选择功能：1
请输入分数：86
成绩评定（if-else）：B
成绩评定（switch）：B
...
请选择功能：2
请输入金字塔层数：5
    *
   * *
  *   *
 *     *
*********
...
计算阶乘：4
计算结果：24
请选择功能：4
再见
```

### 4.1 封装、构造与静态成员

- `Product`：三个属性全部 `private`，提供 Getter/Setter（Setter 中对负价格做了拦截，体现封装的意义）；无参构造器与全参构造器构成重载；`private static int totalProductCount` 在两个构造器里各 `++`，`getTotalCount()` 用类名调用。
- `ProductDemo`：创建两个商品，先调实例方法 `printInfo()`（各自打印自己的数据），再用 `Product.getTotalCount()`（整个类共享的统计）。

```text
商品信息：[P001] 机械键盘, 价格: 450.0元
商品信息：[P002] 蓝牙耳机, 价格: 299.0元
系统当前共创建了 2 个商品实例。
```

### 4.2 继承、抽象类与接口

- `GpsLocatable`：接口，只声明 `String getLocation()`，代表"具备定位能力"这一行为规范。
- `TransportVehicle`：抽象类，持有 `protected String vehicleId` 与带参构造器，抽象方法 `calculateCost(double weight)` 代表"所有运输工具都要计费，但公式待定"。
- `Truck` / `Drone`：`extends` 抽象类并 `implements` 接口，分别按 `重量 * 5.0`、`重量 * 15.0` 重写计费方法，并各自实现定位信息；`toString()` 输出 `卡车 [T-998]` 这类描述。
- `TransportDemo`：用 `TransportVehicle` 引用指向子类对象（多态），同一个 `calculateCost` 调用执行的是子类版本；调用接口方法时把父类引用转成 `GpsLocatable`。

```text
卡车 [T-998] 当前位置：仓库A区 | 配送10kg货物费用：50.0元
无人机 [D-007] 当前位置：高空坐标(39.9, 116.4) | 配送10kg货物费用：150.0元
```

### 4.3 泛型容器特训

- `StorageBox<T>`：属性 `private T item`，`storeItem(T)` 存入、`retrieveItem()` 取出，另加 `takeOut()` 与 `isEmpty()` 便于使用。
- `StorageBoxDemo`：分别构造 `StorageBox<Product>` 与 `StorageBox<TransportVehicle>`，取出时**不需要任何强制类型转换**；并在注释里演示"往 `StorageBox<Product>` 里塞 `Drone` 会直接编译报错"，说明泛型把类型错误提前到了编译期。

```text
商品储物箱存取测试：成功取出商品 -> 机械键盘
设备储物箱存取测试：成功取出设备 -> 无人机 [D-007]
```

### 4.4 手写迷你 ArrayList

- `MyArrayList<T>`：`Object[] elements` + `int size`，初始容量 3。
  - `add`：`size == elements.length` 时新建 2 倍长数组并逐个复制，再让 `elements` 指向新数组，最后 `elements[size] = element; size++;`
  - `get`：先判断 `index < 0 || index >= size`，越界打印提示并返回 `null`，否则 `(T) elements[index]`。
  - `remove`：先记下被删元素用于打印，再 `for` 循环把 `index` 之后的元素整体前移一位，末尾置 `null`、`size--`。
- `MyArrayListDemo`：连续存入 5 个单号（第 4 个触发 3→6 扩容），查询索引 2、删除索引 1 后验证前移，最后做一次越界测试。

```text
成功添加：单号A
成功添加：单号B
成功添加：单号C
触发底层扩容！当前数组容量由 3 扩容至 6
成功添加：单号D
成功添加：单号E
获取索引[2]的元素：单号C
删除了索引[1]的元素(单号B)
验证移位，此时索引[1]的元素变为了：单号C
```

### 4.5 三种经典设计模式

- `LogisticsConfig`（单例）：私有构造器 + `private static final` 唯一实例 + `getInstance()`，两次获取用 `==` 比较为 `true`。
- `VehicleFactory`（简单工厂）：`createVehicle(String type)` 按类型字符串返回 `Truck` / `Drone`，未知类型返回 `null`；调用方只依赖 `TransportVehicle` 抽象类型。
- `LogisticsOrder`（建造者）：私有构造器，静态内部类 `Builder` 持有同样字段，每个选填方法 `return this` 支持链式调用，最后 `build()` 生成订单。

```text
单例测试：配置类实例A与实例B是否相同？ -> true
工厂调度：工厂成功分配 -> 无人机 [D-007]，计费启动...
运单生成：订单号[OD-999], 寄件人[Alice], 收件人[Bob], 易碎品[true], 保价[1000.0元]
```

### 第 5 题：异常与异常处理

- `InsufficientFundsException`：继承 `Exception`（受检），额外带 `transactionId` 字段，构造器同时初始化提示信息与流水号。
- `SystemMaintenanceException`：继承 `RuntimeException`（非受检），提供 `(String)` 与 `(String, Throwable)` 两个构造器，后者用于异常链。
- `PaymentProcessor#pay`：按金额分支抛出 `IllegalArgumentException` / `InsufficientFundsException` / `SystemMaintenanceException`（附带 `NullPointerException` 作为 cause）/ 正常打印交易成功。
- `PaymentService#pay`：`try` 中调用支付；分别 catch 受检异常（打印流水号并返回 `false`）、`IllegalArgumentException`（包装成 `SystemMaintenanceException` 重新抛出）、`Exception`（兜底打印）；`finally` 中固定打印资源清理，最后无异常返回 `true`。
- `PaymentDemo`：四种场景（-100、20000、500、300）逐个测试，`main` 中对重新抛出的异常做了捕获，程序不会崩。

```text
--- 场景一：金额 -100 元 ---
执行资源清理任务...
捕获到异常：系统维护中，请稍后再试
原始异常类型：java.lang.IllegalArgumentException: 支付金额不能为负数
--- 场景二：金额 20000 元 ---
余额不足，流水号为[TXN-002]
执行资源清理任务...
支付结果：false
--- 场景三：金额 500 元 ---
发生未知异常:网络连接超时
执行资源清理任务...
支付结果：false
--- 场景四：金额 300 元 ---
交易[TXN-004]支付成功，金额：300.0
执行资源清理任务...
支付结果：true
```

### 第 6 题：集合运用

- `Order`：`implements Comparable<Order>`，`compareTo` 先比金额（降序，故用 `Double.compare(other.amount, this.amount)`），金额相同再比订单号升序。
- `OrderAnalyzer`：
  - `add`：直接加入 `List<Order>`；
  - `removeInvalidOrders`：**倒序**遍历删除金额 `<= 0` 的订单，避免正序删除导致的漏删；
  - `getAllUniqueTags`：用 `LinkedHashSet` 汇总所有标签（去重且保持顺序）；
  - `getCustomerSpendMap`：用 `TreeMap` 按姓名分组累加金额（`containsKey` 判断是新客户还是累加）；
  - `sortOrdersByCustomerName`：复制一份新 List，再用 `Collections.sort` + 匿名 `Comparator` 按姓名升序，不影响原集合。
- `OrderAnalyzerDemo`：用题目给的 5 条数据依次验证排序、清洗、去重、分组、按姓名排序。

```text
=== 原始订单（按默认规则排序：金额降序，金额相同按订单号升序）===
[O005] Bob 金额:300.0 标签:[服装, 户外]
[O003] Alice 金额:200.0 标签:[图书, 电子]
[O004] Charlie 金额:200.0 标签:[生鲜]
[O001] Alice 金额:150.0 标签:[电子, 数码]
[O002] Bob 金额:-50.0 标签:[服装]
=== 删除金额 <= 0 的无效订单 ===
移除无效订单：O002，金额为 -50.0
剩余订单数：4
=== 全部标签（去重）===
[服装, 户外, 图书, 电子, 生鲜, 数码]
=== 每个客户的总消费 ===
Alice -> 350.0元
Bob -> 300.0元
Charlie -> 200.0元
=== 按客户姓名升序排列（新集合，不影响原列表）===
[O003] Alice 金额:200.0 标签:[图书, 电子]
[O001] Alice 金额:150.0 标签:[电子, 数码]
[O005] Bob 金额:300.0 标签:[服装, 户外]
[O004] Charlie 金额:200.0 标签:[生鲜]
```

### 第 7 题：文件操作

- `FileChunkTransfer#splitFile`：先校验源文件与 `chunkSize`，`while (start < fileLength)` 逐片处理，每片大小取 `min(chunkSize, 剩余字节)`；片内用 8KB 缓冲区读写，读取长度为 `min(缓冲区长度, 本片剩余量)`，因此**最后一片不会多读**。输出文件命名为 `源文件名.partX`。
- `FileChunkTransfer#mergeFile`：`listFiles()` 后按前缀过滤分片，解析 `.part` 后的数字并**按数字排序**（字符串排序会把 `part10` 排到 `part2` 前面），逐个读取追加写入，最后删除所有分片。
- `FileTransferDemo`：生成约 500KB 的测试文本 → 按 100KB 分片（实际得到 5 片，满足"至少 3 片"）→ 合并 → 先比长度再逐字节比较内容，并统计剩余分片数（应为 0）。

```text
测试源文件：...\temp\file-demo\myWords.txt，大小：498893 字节
--- 开始分片，每片上限 100000 字节 ---
已生成分片：myWords.txt.part1，大小：100000 字节
...
已生成分片：myWords.txt.part5，大小：98893 字节
分片总数：5
--- 开始合并 ---
合并完成：...\myWords_merged.txt，共合并 5 个分片
...
--- 一致性校验 ---
源文件大小：498893 字节，合并文件大小：498893 字节
两个文件内容是否完全一致：true
剩余分片数量：0
```

### 第 8 题：线程同步

- `MilkTeaCounter`（吧台）：`put` / `take` 均用 `synchronized` 修饰保证互斥；用 `while (条件) wait()` 而不是 `if`，被唤醒后重新检查条件，可防止虚假唤醒；放入/取走后 `notifyAll()` 唤醒双方。
- `Staff` / `Customer`：实现 `Runnable`，`run` 中 `for` 循环 10 次做/取奶茶，并用 `Thread.sleep()` 模拟制作与饮用耗时；捕获 `InterruptedException` 后恢复中断标记。
- `MilkTeaShopDemo`：2 名店员各做 10 杯（共 20 杯）、2 名顾客各喝 10 杯（共 20 杯），`join()` 等待全部结束后打印收尾信息。

实测结果：吧台数量始终在 0–5 之间，20 次"制作"与 20 次"取走"一一对应，最后两名店员都下班、两名顾客都满足。

```text
--- 奶茶店开始营业 ---
[店员-1]制作了奶茶，吧台当前数量：1
[顾客-2]取走了奶茶，吧台剩余数量：0
...
[店员-2]已完成 10 杯，下班了
[店员-1]已完成 10 杯，下班了
[顾客-1]已喝到 10 杯，满足了
[顾客-2]已喝到 10 杯，满足了
--- 营业结束 ---
所有店员已下班，所有顾客都已满足。
```

---

## 六、几点说明

1. **关于 emoji**：题目示例输出中出现的 📦、🚁 等 emoji，在 Windows 控制台默认 GBK 编码下会显示为乱码，因此程序输出统一改用纯文字描述（如"无人机 [D-007]"），其余文字与题目示例保持一致。
2. **关于控制台编码**：源码统一 UTF-8 保存。若命令行运行出现中文乱码，先执行 `chcp 65001`，或用 IDEA 运行（默认 UTF-8）。
3. **关于泛型告警**：`MyArrayList#get` 中的 `(T) elements[index]` 属于题目要求的向下转型，已用 `@SuppressWarnings("unchecked")` 标注，避免编译告警干扰。
4. **关于题目范围**：本工程对应第 1–8 题；第 9 题（SQL）、第 10–11 题（Spring Boot / Redis / Docker）需要数据库与框架环境，未纳入本 Java 工程。
