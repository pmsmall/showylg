package com.ylg.panel.xz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.ylg.panel.R;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment implements OnClickListener{
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
        rootView.findViewById(R.id.po1).setOnClickListener(this);
        rootView.findViewById(R.id.po2).setOnClickListener(this);
        rootView.findViewById(R.id.po3).setOnClickListener(this);
        rootView.findViewById(R.id.po4).setOnClickListener(this);
        rootView.findViewById(R.id.po5).setOnClickListener(this);

        // Show the dummy content as text in a TextView.
 
        return rootView;
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.po1:
			Intent intent1 = new Intent(this.getActivity(),DiWeiActivity.class);
			startActivity(intent1);
			break;
		case R.id.po2:
			Intent intent2 = new Intent(this.getActivity(),WorkMainActivity.class);
			startActivity(intent2);
			break;
		case R.id.po3:
			Intent intent3 = new Intent(this.getActivity(),BuMenActivity.class);
			startActivity(intent3);
			break;
		case R.id.po4:
			Intent intent4 = new Intent(this.getActivity(),WorkGoalActivity.class);
			startActivity(intent4);
			break;
		case R.id.po5:
			Intent intent5 = new Intent(this.getActivity(),HuoDongActivity.class);
			startActivity(intent5);
			break;
		default:
			break;
		}
	}
}
