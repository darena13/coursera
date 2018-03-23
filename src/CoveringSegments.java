/**
 * Created by darena13 on 22.03.2018.
 */

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }

        int rounds = points.length / 2;
        while (rounds > 0) {
            int[] pointCoolness = new int[points.length];
            for (int i = 0; i < points.length; i += 2) {
                if (points[i] != -1) {
                    for (int j = 0; j < segments.length; j++) {
                        if (segments[j] != null) {
                            if (points[i] >= segments[j].start && points[i] <= segments[j].end) {
                                pointCoolness[i]++;
                            }
                        }
                    }
                }
            }

            int maxPointCoolness = 0;
            int coolestPointIndex = 0;
            for (int i = 0; i < pointCoolness.length; i++) {
                if (pointCoolness[i] > maxPointCoolness) {
                    maxPointCoolness = pointCoolness[i];
                    coolestPointIndex = i;
                }
            }

            if (maxPointCoolness > 0) {
                for (int i = 0; i < segments.length; i++) {
                    if (segments[i] != null) {
                        if (points[coolestPointIndex] >= segments[i].start && points[coolestPointIndex] <= segments[i].end) {
                            int coolestPoint = points[coolestPointIndex];
                            points[i * 2] = -1;
                            points[i * 2 + 1] = -1;
                            points[coolestPointIndex] = coolestPoint;
                            segments[i] = null;
                        }
                    }
                }
            } else {
                rounds = 0;
            }

            rounds--;
        }

        int coolPointsCount = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] != -1) coolPointsCount++;
        }

        int[] coolestPoints = new int[coolPointsCount];

        int count = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] != -1) {
                coolestPoints[count] = points[i];
                count++;
            }
        }

        return coolestPoints;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

