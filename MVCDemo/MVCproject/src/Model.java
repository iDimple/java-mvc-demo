
import java.util.*;
import java.util.Observable;

public class Model extends Observable
{
	protected ArrayList data = new ArrayList();

	public Model()
	{ 
		super();
	}
	public Model(int[] value, String[] name)
	{
		for ( int i = 0; i< value.length; i++ )
		{
			addData(value[i],name[i]);
		}
	}
	public Model(Data[] data)
	{
		for ( int i = 0; i< data.length; i++ )
		{
			addData(data[i]);
		}
	}
	public void addData(int value, String name)
	{
		Data data = new Data();
		data.value = value;
		data.name = name;
		this.data.add(data);
		setChanged(); // Indicates that the model has changed
		notifyObservers(this);
	}
	public void addData(Data data)
	{
		this.data.add(data);
		setChanged(); // Indicates that the model has changed
		notifyObservers(this);
	}
	public Data getData(int idx)
	{
		return (Data)(data.get(idx));
	}

	public int size()
	{
		return data.size();
	}

	// 当数据改变时，由Controller调用此方法，通知各个Observer,刷新视图.
	public void changeModel(Model model)
	{
		data.clear();
		//TODO I don't know whether right or not
		for (int i=0;i<model.size() ;i++ ){
			this.addData(model.getData(i));
		}
		setChanged(); // Indicates that the model has changed
		notifyObservers(this);
	}
}