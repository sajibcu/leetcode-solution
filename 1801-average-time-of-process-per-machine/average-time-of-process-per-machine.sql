SELECT 
    a.machine_id,
    ROUND( 
            (
                SUM(CASE WHEN a.activity_type = 'end' THEN a.timestamp ELSE 0 END) - 
                SUM(CASE WHEN a.activity_type = 'start' THEN a.timestamp ELSE 0 END)
            ) / COUNT(CASE WHEN a.activity_type = 'end' THEN 1 ELSE NULL END), 3
    ) AS processing_time
FROM Activity a
GROUP BY a.machine_id;
