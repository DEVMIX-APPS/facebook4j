/*
 * Copyright 2012 Ryuji Yamashita
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package facebook4j;

import facebook4j.internal.http.HttpParameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ryuji Yamashita - roundrop at gmail.com
 * @since Facebook4J 2.0.0
 */
public class PagePhotoUpdate implements java.io.Serializable {
    private static final long serialVersionUID = -2690799855513822140L;

    private Media source;
    private String message;
    private TargetingParameter targeting;
    private FeedTargetingParameter feedTargeting;
    private Boolean published;
    private Integer scheduledPublishTime;

    public PagePhotoUpdate(Media source) {
        super();
        this.source = source;
    }

    public Media getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PagePhotoUpdate message(String message) {
        setMessage(message);
        return this;
    }

    public TargetingParameter getTargeting() {
        return targeting;
    }

    public void setTargeting(TargetingParameter targeting) {
        this.targeting = targeting;
    }

    public PagePhotoUpdate targeting(TargetingParameter targetingParameter) {
        setTargeting(targetingParameter);
        return this;
    }

    public FeedTargetingParameter getFeedTargeting() {
        return feedTargeting;
    }

    public void setFeedTargeting(FeedTargetingParameter feedTargeting) {
        this.feedTargeting = feedTargeting;
    }

    public PagePhotoUpdate feedTargeting(FeedTargetingParameter feedTargeting) {
        setFeedTargeting(feedTargeting);
        return this;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public PagePhotoUpdate published(boolean published) {
        setPublished(published);
        return this;
    }

    public Integer getScheduledPublishTime() {
        return scheduledPublishTime;
    }

    public void setScheduledPublishTime(Integer scheduledPublishTime) {
        this.scheduledPublishTime = scheduledPublishTime;
    }

    public void setScheduledPublishTime(Date scheduledPublishTime) {
        long time = scheduledPublishTime.getTime() / 1000L;
        setScheduledPublishTime(Long.valueOf(time).intValue());
    }

    public PagePhotoUpdate scheduledPublishTime(Integer scheduledPublishTime) {
        setScheduledPublishTime(scheduledPublishTime);
        return this;
    }

    public PagePhotoUpdate scheduledPublishTime(Date scheduledPublishTime) {
        long time = scheduledPublishTime.getTime() / 1000L;
        return scheduledPublishTime(Long.valueOf(time).intValue());
    }

    /*package*/ HttpParameter[] asHttpParameterArray() {
        List<HttpParameter> params = new ArrayList<HttpParameter>();
        params.add(new HttpParameter("source", source.getMediaFile()));
        if (message != null) {
            params.add(new HttpParameter("message", message));
        }
        if (targeting != null) {
            params.add(new HttpParameter("targeting", targeting.asJSONString()));
        }
        if (feedTargeting != null) {
            params.add(new HttpParameter("feed_targeting", feedTargeting.asJSONString()));
        }
        if (published != null) {
            params.add(new HttpParameter("published", published));
        }
        if (scheduledPublishTime != null) {
            params.add(new HttpParameter("scheduled_publish_time", scheduledPublishTime));
        }
        return params.toArray(new HttpParameter[params.size()]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PagePhotoUpdate)) return false;

        PagePhotoUpdate that = (PagePhotoUpdate) o;

        if (feedTargeting != null ? !feedTargeting.equals(that.feedTargeting) : that.feedTargeting != null)
            return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (published != null ? !published.equals(that.published) : that.published != null) return false;
        if (scheduledPublishTime != null ? !scheduledPublishTime.equals(that.scheduledPublishTime) : that.scheduledPublishTime != null)
            return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (targeting != null ? !targeting.equals(that.targeting) : that.targeting != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (targeting != null ? targeting.hashCode() : 0);
        result = 31 * result + (feedTargeting != null ? feedTargeting.hashCode() : 0);
        result = 31 * result + (published != null ? published.hashCode() : 0);
        result = 31 * result + (scheduledPublishTime != null ? scheduledPublishTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PagePhotoUpdate{" +
                "source=" + source +
                ", message='" + message + '\'' +
                ", targeting=" + targeting +
                ", feedTargeting=" + feedTargeting +
                ", published=" + published +
                ", scheduledPublishTime=" + scheduledPublishTime +
                '}';
    }
}
