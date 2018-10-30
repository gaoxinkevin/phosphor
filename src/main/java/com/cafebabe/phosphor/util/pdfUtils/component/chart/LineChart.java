package com.cafebabe.phosphor.util.pdfUtils.component.chart;

import lombok.extern.slf4j.Slf4j;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import com.cafebabe.phosphor.util.pdfUtils.component.chart.model.XYLine;
import com.cafebabe.phosphor.util.pdfUtils.util.FontUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by fgm on 2017/4/7.
 */
@Slf4j
public abstract class LineChart {


    private  int width;

    private  int height;

    private static int   defaultWidth=500;
    private static int  defaultHeight=220;

    private String fileName;


    public String draw(List<XYLine> lineList, int picId){
        return draw("","","",lineList,picId);
    }

    public  String draw(String title, String xLabel, String yLabel,
                        List<XYLine> lineList, int picId){

        if(lineList==null || lineList.size()==0){
            return "";
        }
        DefaultCategoryDataset dataSet=new DefaultCategoryDataset();
        for(XYLine line:lineList){
            dataSet.addValue(line.getYValue(),line.getGroupName(),line.getXValue());
        }
        try {
            return  drawLineChar(title,xLabel,yLabel,dataSet,picId);
        }catch (Exception ex){
            log.error("画图异常{}",ex);
            return "";
        }

    }

    /**
     * @description 设置自定义的线条和背景色
     */
    protected  abstract void initPlot(JFreeChart  chart,DefaultCategoryDataset dataSet);


    protected void initDefaultXYPlot(CategoryPlot plot){
        // 设置X轴
        CategoryAxis domainAxis = plot.getDomainAxis();
        // 设置横轴字体
        domainAxis.setLabelFont(FontUtil.getFont(Font.PLAIN,13));
        // 设置坐标轴标尺值字体
        domainAxis.setTickLabelFont(FontUtil.getFont(Font.PLAIN,13));
        // 左边距 边框距离
        domainAxis.setLowerMargin(0.01);
        // 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。
        domainAxis.setUpperMargin(0.06);
        domainAxis.setMaximumCategoryLabelLines(10);
        // 横轴 lable 的位置 横轴上的 Lable 45度倾斜 DOWN_45
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        // 设置Y轴
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setLabelFont(FontUtil.getFont(Font.PLAIN, 13));
        //最小跨度
        rangeAxis.setAutoRangeMinimumSize(1);
        //上边距,防止最大的一个数据靠近了坐标轴。
        rangeAxis.setUpperMargin(0.18);
        //最小值显示18
        rangeAxis.setLowerBound(18);
        //最大值显示33
        rangeAxis.setUpperBound(33);
        //不自动分配Y轴数据
        rangeAxis.setAutoRange(false);
        // 设置坐标标记大小
        rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));
        // 设置坐标标记颜色
        rangeAxis.setTickMarkPaint(Color.BLACK);
        //每1个刻度显示一个刻度值
        rangeAxis.setTickUnit(new NumberTickUnit(1));


    }

    /**
     * @description 画出折线图
     * @return 图片地址
     */
    private  String   drawLineChar(String title, String xLabel, String yLabel, DefaultCategoryDataset dataSet, int picId)
            throws IOException {
        JFreeChart lineChartObject= ChartFactory.createLineChart(
                title,
                // 横轴
                xLabel,
                // 纵轴
                yLabel,
                // 获得数据集
                dataSet,
                // 图标方向垂直
                PlotOrientation.VERTICAL,
                // 显示图例
                true,
                // 不用生成工具
                false,
                // 不用生成URL地址
                false
        );
        String path=this.getClass().getClassLoader().getResource("").getPath();
        String filePath=path+"/images/"+picId+"/"+getFileName();
        File lineChart = new File(filePath);
        if(!lineChart.getParentFile().exists()){
            lineChart.getParentFile().mkdirs();
        }
        //初始化表格样式
        initDefaultPlot(lineChartObject,dataSet);

        ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, getWidth() ,getHeight());

        return lineChart.getAbsolutePath();

    }


    private  void  initDefaultPlot(JFreeChart  chart,DefaultCategoryDataset dataSet){
        //设置公共颜色

        // 设置标题字体
        chart.getTitle().setFont(FontUtil.getFont(Font.PLAIN, 15));
        // 设置图例类别字体
        chart.getLegend().setItemFont(FontUtil.getFont(Font.PLAIN, 13));
        // 设置背景色
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setNoDataMessage("无对应的数据。");
        //字体的大小
        plot.setNoDataMessageFont(FontUtil.getFont(Font.PLAIN, 13));
        //字体颜色
        plot.setNoDataMessagePaint(Color.RED);
        //设置自定义颜色
        initPlot(chart,dataSet);

    }



    public int getWidth() {
        if(width==0){
            return defaultWidth;
        }
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        if(height==0){
            return defaultHeight;
        }
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
