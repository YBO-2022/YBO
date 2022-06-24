import React, { useState } from "react";
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from "recharts";
 
function Graph() {
    const data = [
        {
          year: 2000,
          rank:1
        },
        {
            year: 2001,
            rank:2
        },
        {
            year: 2002,
            rank:1
        },
        {
            year: 2003,
            rank:3
        },
        {
            year: 2004,
            rank:5
        },
        {
            year: 2005,
            rank:7
        },
        {
            year: 2006,
            rank:8
        },
        {
            year: 2007,
            rank:9
        }
      ];
      

    return (

    <LineChart
      width={1800}
      height={300}
      data={data}
      margin={{
        top: 5,
        right: 30,
        left: 20,
        bottom: 5
      }}
    >
      <CartesianGrid strokeDasharray="3 3" />
      <XAxis dataKey="year"/>
      <YAxis reversed="True" interval={0}/>
      <Tooltip />
      <Line type="monotone" dataKey="rank" stroke="black" />
    </LineChart>
  );
}


export default Graph;