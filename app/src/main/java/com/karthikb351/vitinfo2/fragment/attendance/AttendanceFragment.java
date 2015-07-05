/*
 * VITacademics
 * Copyright (C) 2015  Gaurav Agerwala <gauravagerwala@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.karthikb351.vitinfo2.fragment.attendance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karthikb351.vitinfo2.R;
import com.karthikb351.vitinfo2.contract.Course;

public class AttendanceFragment extends Fragment{

    Course course;
    RecyclerView recyclerView;
    AttendanceListAdapter listAdapter;

    public AttendanceFragment(){

    }

    public static AttendanceFragment newInstance(Course course){
        AttendanceFragment attendanceFragment= new AttendanceFragment();
        attendanceFragment.course=course;
        return attendanceFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.attendance,container,false);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        listAdapter=new AttendanceListAdapter(getActivity(),course);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_attendance);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
