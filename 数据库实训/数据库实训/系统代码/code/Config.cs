using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace test1
{
    public class SystemInfo
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public string Desc { get; set; }
    }

    class Config
    {
        Config()
        {
            //SystemInfo systemInfo = new SystemInfo();
            //List<SystemInfo> systemInfoList = new List<SystemInfo>();
            //XDocument doc = new XDocument();
            //doc = XDocument.Load("SystemInfo.xml");
            //var classData = (from n in doc.Root.Elements("Class")
            //                 where n.Attribute("name").Value == "News"
            //                 select n).ToList();
            //foreach (var item in classData.Elements("Item"))
            //{
            //    systemInfo.Id = item.Value;
            //    systemInfo.Name = item.Attribute("name").Value;
            //    systemInfo.Desc = item.Attribute("desc").Value;
            //    systemInfoList.Add(systemInfo);
            //}
        }
    }
}
