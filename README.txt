二手市场交易系统后端

本项目由指令集设计模式完成，所有操作均由指令条完成，项目配置简易的指令解析与分发装置，使用最基础的mybatis+java的模式构建了一个功能较为复杂交易后端系统
功能包括但不限于：权限判断，缓存，数据热更新，登录/注册系统，交易操作，管理员模式等

目前只有3号-进入指令集模式的功能式完备的

您好。二手交易系统指令集如下：


//登陆指令集

-login ["1"][account:[phoneNum="",password=""]]   	
-login ["2"][account:[OId="",password=""]]



//注册指令集

-sign ["__username__"]["__phoneNum(不可重复)__"]["__password__"]["__balances(须是正浮点/整值)__"]
-sign [""][""][""][""]



//交易指令集(需保证卖家货物充足，买家资金充足)

-buy [buyerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][sellerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][item:[OId="__(必填)__",name="__(不填)__",description="__(不填)__",price="",num="__(必填)__"]]
-buy [buyerAccount:[OId="",phoneNum="",password=""]][sellerAccount:[OId="",phoneNum="",password=""]][item:[OId="",name="",description="",price="",num=""]]



//注销指令集  *权限9

-clear [ManagerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][otherAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]]
-clear [ManagerAccount:[OId="",phoneNum="",password=""]][otherAccount:[OId="",phoneNum="",password=""]]



//打印、导入、输出指令集 *权限9
/*
    //[Type="cate"]
    //[Type="user"]
    //[Type="item"]
    //[Type="order"]
    //[Type="user-item"]
    //[Type="item-cate"]
*/
-in [ManagerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][Type="__(必填)__"]
-out[ManagerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][Type="__(必填)__"]
-ls [ManagerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][Type="__(必填)__"]

-in [ManagerAccount:[OId="",phoneNum="",password=""]][Type=""]
-out[ManagerAccount:[OId="",phoneNum="",password=""]][Type=""]
-ls [ManagerAccount:[OId="",phoneNum="",password=""]][Type=""]






//统计指令集 *权限9

-detail [ManagerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]]
-detail [ManagerAccount:[OId="",phoneNum="",password=""]]


//查询指令集 *权限9
/*
    //[Type="cate"]
    //[Type="user"]
    //[Type="item"]
    //[Type="order"]
    //[Type="user-item"]
    //[Type="item-cate"]
*/
/*
    //[Text="任意字符串"]
*/
-search [ManagerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][Type="__(必填)__"][Text="__(必填)__"]
-search [ManagerAccount:[OId="",phoneNum="",password=""]][Type=""][Text=""]




//修改指令集  *通用权限

-update 	   	        普通								管理
[UserId] [newUser]  [自己，只有username，password，address，mail，username]	   [所有人，所有值除了OId]
[OrderId] [Order]   [自己的status ,且只能向下]				   [所有人，所有值除了OId]
[ItemId] [newItem]  [自己,除了OId]					   [所有人，所有值除了OId]

//以下打星代表管理权限才可修改



-update [ManagerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][UserId="__(必填,普通用户仅能修改自己)__"][newUser:[OId="__(填)__", status="__(选填*)__", username="__(选填)__", password="__(选填)__", phoneNum="__(选填*)__", email="__(选填)__", address="__(选填)__", regsTime="__(选填*)__", balances="__(选填*)__"]]

-update [ManagerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][OrderId="__(必填，普通用户仅能修改自己拥有的)__"][newOrder:[OId="__(填)__",status="__(选填)__",buyerId="__(选填*)__",sellerId="__(选填*)__",itemsId="__(选填*)__",time="__(选填*)__",num=__(选填*)__,value="__(选填*)__"]]

-update [ManagerAccount:[OId="__(必填)__",phoneNum="",password="__(必填)__"]][ItemId="__(必填，普通用户仅能修改自己拥有的)__"][newItem:[OId="__(填)__",name="__(选填)__",description="__(选填)__",price="",num="__(选填)__"]]


-update [ManagerAccount:[OId="",phoneNum="",password=""]][UserId=""][newUser:[OId="", status="", username="", password="", phoneNum="", email="", address="", regsTime="",balances=""]]

-update [ManagerAccount:[OId="",phoneNum="",password=""]][OrderId=""][newOrder:[OId="",status="",buyerId="",sellerId="",itemsId="",time="",num="",value=""]]

-update [ManagerAccount:[OId="",phoneNum="",password=""]][ItemId=""][newItem:[OId="",name="",description="",price="",num=“”]]





-bye

