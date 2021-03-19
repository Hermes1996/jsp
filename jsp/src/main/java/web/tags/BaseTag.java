///*
// * 文件名：BaseTag.java
// * 版权：Copyright 2012-2013 Li Huaxin Tech. Co. Ltd. All Rights Reserved.
// * 描述： BaseTag.java
// * 修改人：lihuaxin
// * 修改时间：2013-6-12
// * 修改内容：新增
// */
package web.tags;

import java.util.ArrayList;
import java.util.List;

//
//
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.jsp.JspException;
//import javax.servlet.jsp.JspWriter;
//import javax.servlet.jsp.PageContext;
//import javax.servlet.jsp.tagext.DynamicAttributes;
//import javax.servlet.jsp.tagext.JspFragment;
//import javax.servlet.jsp.tagext.JspTag;
//import java.io.IOException;
//import java.io.StringWriter;
//import java.io.Writer;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 基本控件
// *
// * @author lihuaxin
// * @version LMS V100R001 2013-6-12
// * @since LMS V100R001C00
// */
public class BaseTag
{
    private String render;

    public void setRender(String render)
    {
        this.render = render;
    }

    public void addChild(BaseTag child)
    {
        setOutputStringTag();
        getChildren().add(child);
    }

    private void setOutputStringTag()
    {
    }

    protected List<BaseTag> getChildren()
    {
        return new ArrayList<>();
    }

    protected int getColspan()
    {
        return 1;
    }

    protected void setColspan(int colspan)
    {
    }
}
//public class BaseTag extends HtmlComponent implements DynamicAttributes
//{
//    /**
//    * Logger for this class
//    */
//    private static final Log logger = LogFactory.getLog(BaseTag.class);
//
//    /**
//     * 渲染的ftl文件
//     */
//    private String render;
//
//    /**
//     * 是否不输出
//     */
//    private String ignore;
//
//    private BaseTag appParent;
//
//    private List<BaseTag> children = new ArrayList<BaseTag>();
//
//    /**
//     * ftl输出
//     */
//    private StringWriter writer = new StringWriter();
//
//    /**
//     * 动态属性
//     */
//    private Map<String, Object> dynamicAttributes = new HashMap<String, Object>();
//
//    /**
//     * 在父组件中占几列
//     */
//    private int colspan = 1;
//
//    public Map<String, Object> getDynamicAttributes()
//    {
//        return this.dynamicAttributes;
//    }
//
//    public void setDynamicAttribute(String arg0, String localName, Object value) throws JspException
//    {
//        this.dynamicAttributes.put(localName, value);
//    }
//
//    @Override
//    public void doTag() throws JspException, IOException
//    {
//
//        if (is_Ignore())
//        {
//            return;
//        }
//
//        // 自定义标签约定都是BaseTag类型
//        BaseTag parentTag = getParentTag();
//
//        // 设置value
//        prepareDoTag(parentTag);
//
//        if (parentTag != null)
//        {
//            // 添加到父节点中
//            addToParent(parentTag);
//        }
//
//        // 收集孩子节点
//        collectChild();
//
//        // 没有父元素表示由父元素输出
//        if (parentTag == null)
//        {
//            callRender();
//        }
//    }
//
//    private BaseTag getParentTag()
//    {
//        if (this.appParent == null)
//        {
//            JspTag parent = getParent();
//            if ((parent instanceof BaseTag))
//            {
//                this.appParent = ((BaseTag) parent);
//            }
//            else if (parent != null)
//            {
//                this.appParent = ((BaseTag) findAncestorWithClass(this, BaseTag.class));
//            }
//
//        }
//        return this.appParent;
//    }
//
//    /**
//     *
//     * <b>前置动作</b>
//     * <p>
//     * TODO 方法功能描述
//     * <p>
//     *
//     * @param parent
//     *            void
//     */
//    public void prepareDoTag(JspTag parent)
//    {
//        setPropertyRoot(parent);
//        setPropertyValue();
//
//        // 设置样式
//        collectStyle();
//        collectClass();
//    }
//
//    /**
//     * 设置根属性
//     *
//     * <p>TODO 方法功能描述
//     *
//     * @param parent void
//     */
//    public void setPropertyRoot(JspTag parent)
//    {
//
//    }
//
//    public void setPropertyValue()
//    {
//        if (StringUtils.isEmpty(this.name))
//        {
//            return;
//        }
//
//        // 设置值 优先级最高是设置了value
//        if(getValue() == null)
//        {
//            setValue(FindValueUtils.findValue(name));
//        }
//    }
//
//    public void addToParent(BaseTag parent)
//    {
//        parent.addChild(this);
//    }
//
//    public void addChild(BaseTag child)
//    {
//        setOutputStringTag();
//        getChildren().add(child);
//    }
//
//    public void collectChild()
//    {
//        getChildren().clear();
//        doCollectChild();
//    }
//
//    /**
//     * 收集孩子节点
//     *
//     * <p>TODO 方法功能描述
//     *  void
//     */
//    public void doCollectChild()
//    {
//        // doBody会输出子元素，然后子元素调用doTag
//        doBody(writer);
//
//        // 输出标签体内容
//        setOutputStringTag();
//        try
//        {
//            writer.close();
//        }
//        catch (IOException e)
//        {
//        }
//    }
//
//    /**
//     *
//     * 把标签体内容转化为String Tag, &lt;custom&gt; String Tag &lt;/custom&gt;
//     *
//     */
//    public void setOutputStringTag()
//    {
//        // 不输出空格换行字符
//        if (isAllWhiteSpace(writer))
//        {
//            writer.getBuffer().setLength(0);
//            return;
//        }
//
//        // StringTag内容为${value!''}
//        OutputStringTag stringTag = new OutputStringTag();
//        stringTag.setJspContext(getJspContext());
//        stringTag.setParent(this);
//
//        // writer的内容在doBody收集
//        stringTag.setValue(writer.toString());
//
//        writer.getBuffer().setLength(0);
//        addChild(stringTag);
//    }
//
//    public void doBody(Writer output)
//    {
//        JspFragment f = getJspBody();
//        if (null == f)
//        {
//            return;
//        }
//
//        try
//        {
//            // next step is callRender
//            f.invoke(output);
//        }
//        catch (IOException e)
//        {
//            logger.error("io exception in doBody(Writer output), f = " + f.getClass(), e);
//        }
//        catch (JspException e)
//        {
//            logger.error("JspException in doBody(Writer output), f = " + f.getClass(), e);
//        }
//    }
//
//    public void callRender()
//    {
//        JspWriter out = this.getJspContext().getOut();
//        FreeMarkerRenderManager.getRender(render).encode(this, out);
//    }
//
//    public void outputChild()
//    {
//        for (BaseTag child : getChildren())
//        {
//            child.callRender();
//        }
//    }
//
//    public HttpServletRequest getRequest()
//    {
//        HttpServletRequest request = (HttpServletRequest) ((PageContext) getJspContext()).getRequest();
//        return request;
//    }
//
//    /**
//     * 不输出html的空格和换行字符
//     *
//     * <p>TODO 方法功能描述
//     *
//     * @param writer
//     * @return boolean
//     */
//    public static boolean isAllWhiteSpace(StringWriter writer)
//    {
//        if (0 == writer.getBuffer().length())
//        {
//            return true;
//        }
//        StringBuffer strBuf = writer.getBuffer();
//        for (int idx = 0; idx < strBuf.length(); idx++)
//        {
//            char ch = strBuf.charAt(idx);
//            if ((' ' != ch) && ('\r' != ch) && ('\n' != ch) && ('\t' != ch))
//            {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public String getRender()
//    {
//        return render;
//    }
//
//    public void setRender(String render)
//    {
//        this.render = render;
//    }
//
//    public List<BaseTag> getChildren()
//    {
//        return children;
//    }
//
//    public void setChildren(List<BaseTag> children)
//    {
//        this.children = children;
//    }
//
//    public String getName()
//    {
//        return name;
//    }
//
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public Object getValue()
//    {
//        return value;
//    }
//
//    /**
//     * 在doTag > prepareDoTag设置
//     *
//     * <p>TODO 方法功能描述
//     *
//     * @param value
//     */
//    public void setValue(Object value)
//    {
//        this.value = value;
//    }
//
//    public StringWriter getWriter()
//    {
//        return writer;
//    }
//
//    public void setWriter(StringWriter writer)
//    {
//        this.writer = writer;
//    }
//
//    public boolean is_Ignore()
//    {
//        return "true".equals(this.ignore);
//    }
//
//    public String getIgnore()
//    {
//        return this.ignore;
//    }
//
//    public void setIgnore(String ignore)
//    {
//        this.ignore = ignore;
//    }
//
//    public int getColspan()
//    {
//        return colspan;
//    }
//
//    public void setColspan(int colspan)
//    {
//        this.colspan = colspan;
//    }
//
//}
