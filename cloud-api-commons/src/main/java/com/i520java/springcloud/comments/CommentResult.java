package com.i520java.springcloud.comments;/**
 * date: 2020/4/29 20:17<br/>
 *
 * @author jinge<br />
 * @version
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 * @since JDK 1.8
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @PackageName:com.i520java.springcloud.entity
 * @ClassName:CommentResult
 * @author:金格[JIN_GE]
 * @date:2020/4/29 20:17 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {
    private  Integer code;
    private  String message;
    private  T   Data;
    public CommentResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
