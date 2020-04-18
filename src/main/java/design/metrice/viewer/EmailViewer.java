package design.metrice.viewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import design.metrice.EmailSender;
import design.metrice.model.RequestStat;

/**
 * @ClassName: EmailViewer
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/1
 */
public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<String>();

    public EmailViewer(List<String> toAddresses)
    {
        this.toAddresses = toAddresses;
        this.emailSender = new EmailSender();
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    public void output(
        Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        // format the requestStats to HTML style.
        // send it to email toAddresses.
    }
}
