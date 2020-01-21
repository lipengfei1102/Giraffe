--创建数据库--

create database 人事管理
on(
name=人事管理,
size=5MB,
maxsize=100MB,
filename='d:\人事管理.mdf',
filegrowth=10%
)

log
on(
name=人事管理_log,
size=5MB,
filename='d:\人事管理_log.ldf',
filegrowth=1MB
)

--创建表--

if exists ( select name from sysobjects where name='员工基本信息表')
drop table 员工基本信息表
create table 员工基本信息表
(
员工编号  varchar(20),
姓名  varchar(20),
性别  varchar(20),
年龄  int,
联系电话  varchar(20),
primary key (员工编号),
)
if exists ( select name from sysobjects where name='员工婚姻信息表')
drop table 员工婚姻信息表
create table 员工婚姻信息表
(
员工编号  varchar(20),
是否结婚  varchar(20),
配偶姓名  varchar(20),
配偶工作单位  varchar(20),
配偶联系电话  varchar(20),
primary key (员工编号),
)
if exists ( select name from sysobjects where name='学历信息表')
drop table 学历信息表
create table 学历信息表
(
员工编号  varchar(20),
学历  varchar(20),
毕业学校  varchar(20),
毕业时间  varchar(20),
专业  varchar(20),
primary key (员工编号),
)
if exists ( select name from sysobjects where name='岗位信息表')
drop table 岗位信息表
create table 岗位信息表
(
岗位编号  varchar(20),
名称  varchar(20),
要求学校  varchar(20),
要求专业  varchar(20),
基本薪资  int,
primary key (岗位编号),
)
if exists ( select name from sysobjects where name='部门信息表')
drop table 部门信息表
create table 部门信息表
(
部门编号  varchar(20),
名称  varchar(20),
联系电话  varchar(20),
负责人  varchar(20),
primary key (部门编号),
)
--约束描述--

员工基本信息表的主键为 员工编号,存在主键约束



员工婚姻信息表的主键为 员工编号,存在主键约束



学历信息表的主键为 员工编号,存在主键约束



岗位信息表的主键为 岗位编号,存在主键约束



部门信息表的主键为 部门编号,存在主键约束



--创建查询--

SELECT 性别,年龄
FROM 员工基本信息表


SELECT 配偶工作单位,是否结婚
FROM 员工婚姻信息表


SELECT 专业,毕业时间
FROM 学历信息表


SELECT 名称,岗位编号
FROM 岗位信息表


SELECT 负责人,部门编号
FROM 部门信息表


--创建索引--

if exists(select * from sysindexes where id=object_id('员工基本信息表') and name='员工基本信息表索引') 
DROP INDEX 员工基本信息表.员工基本信息表索引
CREATE INDEX 员工基本信息表索引 ON 员工基本信息表(性别)


if exists(select * from sysindexes where id=object_id('员工婚姻信息表') and name='员工婚姻信息表索引') 
DROP INDEX 员工婚姻信息表.员工婚姻信息表索引
CREATE INDEX 员工婚姻信息表索引 ON 员工婚姻信息表(配偶工作单位)


if exists(select * from sysindexes where id=object_id('学历信息表') and name='学历信息表索引') 
DROP INDEX 学历信息表.学历信息表索引
CREATE INDEX 学历信息表索引 ON 学历信息表(专业)


if exists(select * from sysindexes where id=object_id('岗位信息表') and name='岗位信息表索引') 
DROP INDEX 岗位信息表.岗位信息表索引
CREATE INDEX 岗位信息表索引 ON 岗位信息表(名称)


if exists(select * from sysindexes where id=object_id('部门信息表') and name='部门信息表索引') 
DROP INDEX 部门信息表.部门信息表索引
CREATE INDEX 部门信息表索引 ON 部门信息表(负责人)


--创建视图--

if exists (SELECT * FROM sysobjects WHERE id=object_id('员工基本信息表视图'))
DROP VIEW 员工基本信息表视图
go
CREATE VIEW 员工基本信息表视图
AS
SELECT 联系电话,性别
FROM 员工基本信息表


if exists (SELECT * FROM sysobjects WHERE id=object_id('员工婚姻信息表视图'))
DROP VIEW 员工婚姻信息表视图
go
CREATE VIEW 员工婚姻信息表视图
AS
SELECT 配偶联系电话,配偶工作单位
FROM 员工婚姻信息表


if exists (SELECT * FROM sysobjects WHERE id=object_id('学历信息表视图'))
DROP VIEW 学历信息表视图
go
CREATE VIEW 学历信息表视图
AS
SELECT 学历,专业
FROM 学历信息表


if exists (SELECT * FROM sysobjects WHERE id=object_id('岗位信息表视图'))
DROP VIEW 岗位信息表视图
go
CREATE VIEW 岗位信息表视图
AS
SELECT 要求专业,名称
FROM 岗位信息表


if exists (SELECT * FROM sysobjects WHERE id=object_id('部门信息表视图'))
DROP VIEW 部门信息表视图
go
CREATE VIEW 部门信息表视图
AS
SELECT 联系电话,负责人
FROM 部门信息表


--创建触发器--
















--创建存储过程--

create procedure find员工编号(@ID varchar(20))
as
select * from 员工基本信息表
where m_strName.员工编号=@ID



create procedure find员工编号(@ID varchar(20))
as
select * from 员工婚姻信息表
where m_strName.员工编号=@ID



create procedure find员工编号(@ID varchar(20))
as
select * from 学历信息表
where m_strName.员工编号=@ID



create procedure find岗位编号(@ID varchar(20))
as
select * from 岗位信息表
where m_strName.岗位编号=@ID



create procedure find部门编号(@ID varchar(20))
as
select * from 部门信息表
where m_strName.部门编号=@ID




