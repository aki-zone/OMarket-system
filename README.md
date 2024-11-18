# MySQL指令集模仿 - 交易系统 | MySQL-like Command Set Simulation - Second-hand Trading System

## 项目背景 | Project Background

本项目是一个创新性的个人开源作品，旨在模仿MySQL指令集的交互方式，通过自定义指令实现完整的交易系统后端。

This is an innovative personal open-source project that simulates MySQL command set interactions, implementing a complete second-hand trading system backend through custom instructions.

## 核心设计理念 | Core Design Concept

- 🎯 **指令集模拟**：精确模仿MySQL命令行交互模式
- 🔧 **指令解析与分发**：自主设计的指令解析装置
- 🛡️ **权限与安全**：细粒度的权限管理机制

- 🎯 **Command Set Simulation**: Precisely mimicking MySQL command-line interaction mode
- 🔧 **Instruction Parsing and Distribution**: Self-designed instruction parsing device
- 🛡️ **Permission and Security**: Fine-grained permission management mechanism

## 技术亮点 | Technical Highlights

- 指令集设计模式
- MyBatis + Java基础架构
- 模块化指令解析系统
- 细致的权限控制
- 动态数据热更新

- Command Set Design Pattern
- MyBatis + Java Infrastructure
- Modular Instruction Parsing System
- Detailed Permission Control
- Dynamic Data Hot Update

## 指令集示例 | Command Set Examples

### MySQL风格指令 | MySQL-like Commands
```bash
# 登录 | Login
-login ["1"][account:[phoneNum="13800138000",password="123456"]]

# 购买商品 | Purchase Item
-buy [buyerAccount:[OId="user1"]]
      [sellerAccount:[OId="user2"]]
      [item:[OId="item1",name="二手笔记本",price="3000",num="1"]]
```

## 项目价值 | Project Value

1. 展示指令集设计能力  /  Demonstrate Command Set Design Skills
2. 模拟真实数据库交互模式 / Simulate Real Database Interaction Mode
3. 实现复杂后端系统架构 / Implement Complex Backend System Architecture
4. 体现面向对象设计思想 / Reflect Object-Oriented Design Philosophy


## 开发者 | Developer
Aki

## 许可证 | License
Copyright (c) [2022] [akizora]
Licensed under the Personal Open Source License. See LICENSE file for details.
