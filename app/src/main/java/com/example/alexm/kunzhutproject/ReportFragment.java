package com.example.alexm.kunzhutproject;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Adapter;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

public class ReportFragment extends Fragment {

    private List<Question> answers;
    public void setAnswers(final List<Question> questions) {
        this.answers = answers;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.report_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ArrayList<String> steps = new ArrayList();
        steps.add("«Импортонезависимую технологическую платформу для разработки распределенных информационно-вычислительных систем на основе свободного" +
                " программного обеспечения» разработали ученые лаборатории информационных " +
                "технологий Всероссийского НИИ овцеводства");
        steps.add("«На сегодняшний день существуют российские программные " +
                "продукты, но почти все они работают под управлением операционной системы Windows," +
                " либо используют программные библиотеки и компоненты иностранных " +
                "компаний, а значит в любом случае импортозависимы");
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ReportAdapter adapter = new ReportAdapter ();
        adapter.setSteps(steps);
        recyclerView.setAdapter(adapter);
    }

    private static class ReportAdapter extends RecyclerView.Adapter<StepViewHolder>{
        private List<String> steps;

        public void setSteps(List<String> steps) {
            this.steps = steps;
            notifyDataSetChanged();
        }

        @Override
        public StepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int layoutForSteps = R.id.steps_layout;
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.steps_layout, parent, false);
            return new StepViewHolder(view);
        }

        @Override
        public void onBindViewHolder(StepViewHolder holder, int position) {
            final String stepText = steps.get(position);
            holder.stepView.setText(steps.get(position));
        }

        @Override
        public int getItemCount() {
            return steps.size();
        }
    }
    private static class StepViewHolder extends RecyclerView.ViewHolder {

        private TextView stepView;

        public StepViewHolder(final View itemView) {
            super(itemView);
            stepView = (TextView) itemView.findViewById(R.id.stepView);
        }

    }}