package local.alfonso.kitchen.models;

import java.text.SimpleDateFormat;
import java.util.Date;


// adapted from https://tools.ietf.org/html/rfc7807
public class ErrorDetail
{
    private String title;
    private int status;
    private String detail;
    private String timestamp;
    private String developerMessage;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Long timestamp)
    {
        this.timestamp = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(new Date(timestamp));
    }

    public String getDeveloperMessage()
    {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage)
    {
        this.developerMessage = developerMessage;
    }

}
