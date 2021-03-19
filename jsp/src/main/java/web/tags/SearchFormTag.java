package web.tags;


import java.util.Iterator;
import java.util.List;

/**
 * 
 * 搜索表单标签
 *
 * @author liunancun
 * @version Bessky V100R001 2018年6月16日
 * @since Bessky V100R001C00
 */
public class SearchFormTag extends BaseTag
{
    private String action;

    private String method;

    private String onsubmit;

    private int pageno;

    private int pagesize;

    private int totalcount;

    public SearchFormTag()
    {
        setRender("searchform");
    }

    @Override
    public List<BaseTag> getChildren()
    {
        List<BaseTag> childrens = super.getChildren();

        int colspansum = 0;

        Iterator<BaseTag> it = childrens.iterator();
        while (it.hasNext())
        {
            BaseTag children = it.next();
            if (children instanceof SearchItemTag)
            {
                SearchItemTag tag = (SearchItemTag) children;

                int colspan = tag.getColspan();
                if (colspan > 3 - colspansum % 3)
                {
                    colspan = 3 - colspansum % 3;
                }

                colspansum += colspan;
                tag.setColspan(colspan);

                continue;
            }

            it.remove();
        }

        return childrens;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getOnsubmit()
    {
        return onsubmit;
    }

    public void setOnsubmit(String onsubmit)
    {
        this.onsubmit = onsubmit;
    }

    public int getPageno()
    {
        return pageno;
    }

    public void setPageno(int pageno)
    {
        this.pageno = pageno;
    }

    public int getPagesize()
    {
        return pagesize;
    }

    public void setPagesize(int pagesize)
    {
        this.pagesize = pagesize;
    }

    public int getTotalcount()
    {
        return totalcount;
    }

    public void setTotalcount(int totalcount)
    {
        this.totalcount = totalcount;
    }
}
