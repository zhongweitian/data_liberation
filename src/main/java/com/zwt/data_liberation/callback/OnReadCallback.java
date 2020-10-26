package com.zwt.data_liberation.callback;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/1/18 12:34
 * 用于截取读取文件输出的每行文本信息
 */
public interface OnReadCallback {
    void onReadLine(String line);
}
