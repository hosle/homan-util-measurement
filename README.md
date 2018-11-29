# homan-util-measurement



Author: hosle

created at Nov 29th 2018

-----

## Currency

* fenToYuan RMB 分转元


## Kilo

* kilometer
* kilogram


## Time

* 格式化时间，自定义初始与目标时间格式。input：String， output： String

```
fun formatDate(originalDateString: String?, fromFormat: String, toFormat: String): String
```

* 格式化时间，input：Calendar， output：String

```
fun formatTime(calendar: Calendar?, toFormat: String): String
```
* 计算两个Date实例间的相差天数

```
fun getDiffDays(date1: Date?, date2: Date?): Long
```

* 判断是否是今天

```
fun isToday(calendar: Calendar):Boolean
```

* sec时间戳转换两个单位的时间表示

```
**天**小时
**小时**分
**分**秒
fun formatPeroidTime(second: Long): String
```

