package web.tags;

/**
 * 
 * 搜索项目标签
 *
 * @author liunancun
 * @version Bessky V100R001 2018年6月16日
 * @since Bessky V100R001C00
 */
public class SearchItemTag extends BaseTag
{
    /**
     * 标签名称
     */
    private String label;

    /**
     * 是否定制
     */
    private boolean custom;

    public SearchItemTag()
    {
        setRender("searchitem");
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public boolean isCustom()
    {
        return custom;
    }

    public void setCustom(boolean custom)
    {
        this.custom = custom;
    }
}
